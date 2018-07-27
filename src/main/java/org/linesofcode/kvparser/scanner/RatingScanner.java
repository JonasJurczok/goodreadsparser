package org.linesofcode.kvparser.scanner;

import org.linesofcode.kvparser.Context;

public class RatingScanner implements Scanner {
	@Override
	public boolean isApplicable(Context context) {
		if (context.getBook() == null) {
			return false;
		}

		return context.getLine().contains("Average rating:");
	}

	@Override
	public void apply(Context context) {
		context.jump(3);

		Double avgRating = Double.valueOf(context.getLine().trim());
		context.getBook().setAverageRating(avgRating);

		context.jump(2);

		String ratings = context.getLine().trim();
		ratings = ratings.replace("(", "")
			.replace("ratings)", "")
			.replace("rating)", "")
			.replace(",", "")
			.trim();

		context.getBook().setRatings(Integer.valueOf(ratings));
	}
}
