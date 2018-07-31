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

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class TypeScannerMatchingTest {

	private final TypeScanner scanner = new TypeScanner(Paths.get("src/test/resources/types.txt"));

	private String line;
	private String expectedKeyword;
	private String expectedDisplayName;

	public TypeScannerMatchingTest(String line, String expectedKeyword, String expectedDisplayName) {
		this.line = line;
		this.expectedKeyword = expectedKeyword;
		this.expectedDisplayName = expectedDisplayName;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
			{"Paperback", "Paperback", "print"},
			{"Paperback, 341 pages", "Paperback", "print"},
			{"Unedited, Paperback, 341 pages", "Paperback", "print"},
			{"Unedited   ,     Paperback    , 222 pages", "Paperback", "print"},
			{"Unedited, Paperback", "Paperback", "print"},
			{"341 pages", "", ""},
			{"Unedited Paperback", "Unedited Paperback", "print"},
			{"Unedited Paperback, 333 pages", "Unedited Paperback", "print"},
			{"/facebook/login_an", "", ""},
			{"Audiobook, 3 pages", "Audiobook", "other"},
			{"CD-ROM, 3 pages", "CD-ROM", "other"},
			{"bookTitle Paperback, 3 pages", "", ""}
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
			assertThat(book.getTypeDisplayName(), is(expectedDisplayName));
		}
	}
}
