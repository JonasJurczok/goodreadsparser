package org.linesofcode.goodreadsscraper;

import org.linesofcode.goodreadsscraper.scanner.LanguageScanner;
import org.linesofcode.goodreadsscraper.scanner.NewBookScanner;
import org.linesofcode.goodreadsscraper.scanner.RatingScanner;
import org.linesofcode.goodreadsscraper.scanner.Scanner;
import org.linesofcode.goodreadsscraper.scanner.TitleScanner;
import org.linesofcode.goodreadsscraper.scanner.TypeScanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Scraper {

	private final List<Scanner> scanners;


	public Scraper() {
		scanners = new ArrayList<>();
		scanners.add(new TitleScanner());
		scanners.add(new NewBookScanner());
		scanners.add(new TypeScanner());
		scanners.add(new LanguageScanner());
		scanners.add(new RatingScanner());
	}

	public List<Book> scrape(String target) {
		System.out.println(String.format("Starting to scrape %s", target));
		try {
			URL url = new URL(target);
			BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream()));

			Context context = new Context(input);
			while (context.next()) {
				for (Scanner scanner : scanners) {
					if (scanner.isApplicable(context)) {
						scanner.apply(context);
					}
				}
			}

			input.close();
			return context.getBooks();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
