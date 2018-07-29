package org.linesofcode.goodreadsscraper.scanner;

import org.linesofcode.goodreadsscraper.Context;

public interface Scanner {

	boolean isApplicable(Context context);

	void apply(Context context);
}
