package org.linesofcode.goodreadsparser;

public class Book {

	private String title;
	private String type;
	private String language;
	private Double averageRating;
	private Integer ratings;

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
