package org.linesofcode.goodreadsscraper.scanner;

import org.linesofcode.goodreadsscraper.Context;

public class TypeScanner implements Scanner {
	@Override
	public boolean isApplicable(Context context) {
		if (context.getBook() == null) {
			return false;
		}

		String line = context.getLine();
		return line.contains(" pages") || line.contains("Audiobook") || line.contains("Audio CD") || line.contains("Audible Audio");
	}

	@Override
	public void apply(Context context) {
		String line = context.getLine();

		String type = line.trim();
		if (line.contains(",")) {
			type = line.substring(0, line.lastIndexOf(",")).trim();
			while (type.contains(",")) {
				type = type.substring(type.indexOf(",") + 1);
			}
		}
		context.getBook().setType(type);
	}
}
