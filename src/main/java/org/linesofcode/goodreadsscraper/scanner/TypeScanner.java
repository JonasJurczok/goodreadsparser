package org.linesofcode.goodreadsscraper.scanner;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.linesofcode.goodreadsscraper.Context;
import org.linesofcode.goodreadsscraper.Type;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TypeScanner implements Scanner {

	private List<Type> types = new ArrayList<>();

	public TypeScanner(Path path) {
		try(Reader reader = Files.newBufferedReader(path)) {
			CsvToBean<Type> parser = new CsvToBeanBuilder<Type>(reader)
				.withType(Type.class)
				.withIgnoreLeadingWhiteSpace(true)
				.build();

			parser.iterator().forEachRemaining(types::add);
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

		if (line.contains("bookTitle")) {
			return false;
		}

		for (Type type : types) {
			if (contains(line, type.getType())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void apply(Context context) {
		String line = context.getLine();

		Type foundType = null;
		for (Type type : types) {
			if (contains(line, type.getType())) {
				foundType = type;
				break;
			}
		}

		if (foundType == null) {
			throw new RuntimeException("TypeScanner seems applicable, but no keyword could be found in line [" + line + "]");
		}

		for (String part : line.split(",")) {
			if (contains(part, foundType.getType())) {
				context.getBook().setType(part.trim());
				context.getBook().setTypeDisplayName(foundType.getDisplayName());
				System.out.println(String.format("Found type %s.", part));
				break;
			}
		}
	}

	private boolean contains(String haystack, String needle) {
		int index = haystack.indexOf(needle);
		return (index >= 0 && (index == 0 || haystack.charAt(index - 1) == ' '));
	}

	public List<Type> getTypes() {
		return types;
	}
}
