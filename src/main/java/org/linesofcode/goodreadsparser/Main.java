package org.linesofcode.goodreadsparser;

import org.linesofcode.goodreadsparser.scanner.LanguageScanner;
import org.linesofcode.goodreadsparser.scanner.NewBookScanner;
import org.linesofcode.goodreadsparser.scanner.RatingScanner;
import org.linesofcode.goodreadsparser.scanner.Scanner;
import org.linesofcode.goodreadsparser.scanner.TypeScanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		/**
		 * TODO;
		 * - input als Liste Titel -> URL
		 * - Output als CSV
		 * - README
		 *
		 * - Tests
		 * - Konfigurierbarer Scanner?
		 * - input/output konfigurierbar
		 * - URL Suche?
		 */

		final List<Scanner> scanners = new ArrayList<>();
		scanners.add(new NewBookScanner());
		scanners.add(new TypeScanner());
		scanners.add(new LanguageScanner());
		scanners.add(new RatingScanner());

		BufferedReader in = liveReader();

		Context context = new Context(in);
		while (context.next()) {

			for (Scanner scanner : scanners) {
				if (scanner.isApplicable(context)) {
					scanner.apply(context);
				}
			}
			//System.out.println(context.getLine());
		}

		in.close();

		System.out.println("Found books:");
		context.getBooks().forEach(System.out::println);
	}

	private static BufferedReader testReader() throws FileNotFoundException {
		final String urlString = "src/main/resources/input.html";

		return new BufferedReader(new FileReader(new File(urlString)));
	}

	private static BufferedReader liveReader() throws IOException {
		final String urlString = "https://www.goodreads.com/work/editions/5431515-the-first-days?expanded=true";
		URL url = new URL(urlString);
		return new BufferedReader(new InputStreamReader(url.openStream()));
	}
}
