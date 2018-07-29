package org.linesofcode.goodreadsscraper;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Writer {

	private final StatefulBeanToCsv<Book> csvWriter;
	private final java.io.Writer writer;

	public Writer(){
		try {
			writer = Files.newBufferedWriter(Paths.get("output.csv"));
			csvWriter = new StatefulBeanToCsvBuilder<Book>(writer).build();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void write(List<Book> books) {
		try {
			csvWriter.write(books);
			writer.flush();
		} catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
