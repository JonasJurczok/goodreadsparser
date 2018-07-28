package org.linesofcode.goodreadsparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Context {

	private final BufferedReader reader;
	private String line;
	private List<Book> books = new ArrayList<>();
	private Book book;

	public Context(BufferedReader reader) {
		this.reader = reader;
	}

	public boolean next() {
		try {
			line = reader.readLine();

			return line != null;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void jump(int rows) {
		for (int i = 0; i < rows; i++) {
			next();
		}
	}

	public void add(Book book) {
		books.add(book);
		this.book = book;
	}

	public String getLine() {
		return line;
	}

	public List<Book> getBooks() {
		return books;
	}

	public Book getBook() {
		return book;
	}
}
