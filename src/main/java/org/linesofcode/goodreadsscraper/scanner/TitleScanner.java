package org.linesofcode.goodreadsscraper.scanner;

import org.linesofcode.goodreadsscraper.Context;

public class TitleScanner implements Scanner {
	@Override
	public boolean isApplicable(Context context) {
		if (context.getTitle() != null && !context.getTitle().isEmpty()) {
			return false;
		}

		return context.getLine().contains("<title>");
	}

	@Override
	public void apply(Context context) {
		context.jump(1);

		String title = context.getLine().replace("Editions of ", "");
		title = title.substring(0, title.indexOf("by")).trim();
		context.setTitle(title);

		System.out.println(String.format("Found title %s", title));
	}
}
