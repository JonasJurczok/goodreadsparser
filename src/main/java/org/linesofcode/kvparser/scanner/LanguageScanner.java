package org.linesofcode.kvparser.scanner;

import org.linesofcode.kvparser.Context;

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
