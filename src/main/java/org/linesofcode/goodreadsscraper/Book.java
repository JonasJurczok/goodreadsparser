package org.linesofcode.goodreadsscraper;

import com.opencsv.bean.CsvBindByPosition;

public class Book {

	@CsvBindByPosition(position = 0)
	private String title;

	@CsvBindByPosition(position = 1)
	private String type;

	@CsvBindByPosition(position = 2)
	private Integer ratings;

	@CsvBindByPosition(position = 3)
	private Double averageRating;

	@CsvBindByPosition(position = 4)
	private String language;


	public Book() {
		this("");
	}

	public Book(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLanguage() {
		return language;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

	public Double getAverageRating() {
		return averageRating;
	}

	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}

	public Integer getRatings() {
		return ratings;
	}

	@Override
	public String toString() {
		return title + ", " + type + ", " + language + ", " + averageRating + ", " + ratings;
	}
}
