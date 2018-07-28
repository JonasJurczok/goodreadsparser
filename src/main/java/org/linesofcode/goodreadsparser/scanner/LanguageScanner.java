package org.linesofcode.goodreadsparser.scanner;

import org.linesofcode.goodreadsparser.Context;

public class LanguageScanner implements Scanner {
	@Override
	public boolean isApplicable(Context context) {
		if (context.getBook() == null) {
			return false;
		}
		return context.getLine().contains("Edition language:");
	}

	@Override
	public void apply(Context context) {
		context.jump(3);
		context.getBook().setLanguage(context.getLine().trim());
	}
}
