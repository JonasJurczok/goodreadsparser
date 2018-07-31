package org.linesofcode.goodreadsscraper.scanner;

import org.junit.Test;
import org.linesofcode.goodreadsscraper.Type;

import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TypeScannerTest {
	private final TypeScanner scanner = new TypeScanner(Paths.get("src/test/resources/types.txt"));

	@Test
	public void scannerShouldBeInitializedCorrectly() {
		List<Type> types = scanner.getTypes();
		assertThat(types.size(), is(4));
	}
}
