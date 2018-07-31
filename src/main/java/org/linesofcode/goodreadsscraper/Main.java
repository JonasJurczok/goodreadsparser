package org.linesofcode.goodreadsscraper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) throws IOException {

		/**
		 * TODO;
		 * - Tests
		 * - Konfigurierbarer Scanner?
		 * - URL Suche?
		 */
		Writer writer = new Writer();
		Scraper scraper = new Scraper();

		try {
			Files.lines(Paths.get("input.csv"))
				.map(scraper::scrape)
				.forEach(writer::write);
		} catch (NoSuchFileException e) {
			System.out.println("Could not find input file input.csv. Please create one and put every URL in a new line.");
		}
	}
}
