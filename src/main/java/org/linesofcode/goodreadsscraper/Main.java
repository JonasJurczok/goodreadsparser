package org.linesofcode.goodreadsscraper;

import org.linesofcode.goodreadsscraper.scanner.LanguageScanner;
import org.linesofcode.goodreadsscraper.scanner.NewBookScanner;
import org.linesofcode.goodreadsscraper.scanner.RatingScanner;
import org.linesofcode.goodreadsscraper.scanner.Scanner;
import org.linesofcode.goodreadsscraper.scanner.TypeScanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		/**
		 * TODO;
		 * - input als Liste Titel -> URL
		 * - konfigurierbarer Typfilter
		 * - README
		 *
		 * - Tests
		 * - Konfigurierbarer Scanner?
		 * - input/output konfigurierbar
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
