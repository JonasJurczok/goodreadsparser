package org.linesofcode.goodreadsscraper.scanner;

import org.linesofcode.goodreadsscraper.Book;
import org.linesofcode.goodreadsscraper.Context;

public class NewBookScanner implements Scanner {
	@Override
	public boolean isApplicable(Context context) {
		return context.getLine().contains("bookTitle");
	}

	@Override
	public void apply(final Context context) {
		System.out.println("Found new book with title " + context.getTitle());
		context.add(new Book());
	}
}
