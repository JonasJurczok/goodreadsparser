package org.linesofcode.goodreadsscraper.scanner;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TypeScannerTest {

	@Test
	public void unabridgedAudioShouldBeDetectedCorrectly() {

	}


	private static BufferedReader testReader() throws FileNotFoundException {
		final String urlString = "src/main/resources/input.html";

		return new BufferedReader(new FileReader(new File(urlString)));
	}
}
