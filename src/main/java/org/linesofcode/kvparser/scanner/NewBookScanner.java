package org.linesofcode.kvparser.scanner;

import org.linesofcode.kvparser.Book;
import org.linesofcode.kvparser.Context;

public class NewBookScanner implements Scanner {
	@Override
	public boolean isApplicable(Context context) {
		return context.getLine().contains("bookTitle");
	}

	@Override
	public void apply(final Context context) {
		final String line = context.getLine();
		Book book = new Book(line.substring(line.indexOf(">") + 1, line.lastIndexOf("<")));
		context.add(book);
	}
}
