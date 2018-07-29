package org.linesofcode.goodreadsscraper.scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.linesofcode.goodreadsscraper.Book;
import org.linesofcode.goodreadsscraper.Context;
import org.mockito.Mockito;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class TypeScannerMatchingTest {

	private final TypeScanner scanner = new TypeScanner(Paths.get("src/test/resources/types.txt"));

	private String line;
	private String expectedKeyword;

	public TypeScannerMatchingTest(String line, String expectedKeyword) {
		this.line = line;
		this.expectedKeyword = expectedKeyword;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
			{"Paperback", "Paperback"},
			{"Paperback, 341 pages", "Paperback"},
			{"Unedited, Paperback, 341 pages", "Paperback"},
			{"Uneidted   ,     Paperback    , 222 pages", "Paperback"},
			{"Unedited, Paperback", "Paperback"},
			{"341 pages", ""},
			{"Unedited Paperback", "Unedited Paperback"},
			{"Unedited Paperback, 333 pages", "Unedited Paperback"}
		});
	}

	@Test
	public void KeywordsShouldBeDetectedCorrectly() {
		Book book = new Book();
		Context context = Mockito.mock(Context.class);
		when(context.getLine()).thenReturn(line);
		when(context.getBook()).thenReturn(book);

		boolean applicable = scanner.isApplicable(context);
		assertThat(applicable, is(!expectedKeyword.isEmpty()));
		if (applicable) {
			scanner.apply(context);
			assertThat(book.getType(), is(expectedKeyword));
		}
	}
}
