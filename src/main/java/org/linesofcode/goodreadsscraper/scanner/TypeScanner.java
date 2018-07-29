package org.linesofcode.goodreadsscraper.scanner;

import org.linesofcode.goodreadsscraper.Context;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TypeScanner implements Scanner {

	private List<String> types = new ArrayList<>();

	public TypeScanner(Path path) {
		try {
			Files.lines(path)
				.forEach(types::add);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean isApplicable(Context context) {
		if (context.getBook() == null) {
			return false;
		}

		String line = context.getLine();
		for (String type : types) {
			if (line.contains(type)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void apply(Context context) {
		String line = context.getLine();

		String foundType = null;
		for (String type : types) {
			if (line.contains(type)) {
				foundType = type;
				break;
			}
		}

		if (foundType == null) {
			throw new RuntimeException("TypeScanner seems applicable, but no keyword could be found in line [" + line + "]");
		}

		for (String part : line.split(",")) {
			if (part.contains(foundType)) {
				context.getBook().setType(part.trim());
				System.out.println(String.format("Found type %s.", part));
				break;
			}
		}
	}

	public List<String> getTypes() {
		return types;
	}
}
