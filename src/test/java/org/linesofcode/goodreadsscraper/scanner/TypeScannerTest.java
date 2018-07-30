package org.linesofcode.goodreadsscraper.scanner;

import org.junit.Test;

import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TypeScannerTest {
	private final TypeScanner scanner = new TypeScanner(Paths.get("src/test/resources/types.txt"));

	@Test
	public void scannerShouldBeInitializedCorrectly() {
		List<String> types = scanner.getTypes();
		assertThat(types.size(), is(3));
		assertThat(types.contains("Paperback"), is(true));
		assertThat(types.contains("ebook"), is(true));
		assertThat(types.contains("Kindle Edition"), is(true));
	}
}
