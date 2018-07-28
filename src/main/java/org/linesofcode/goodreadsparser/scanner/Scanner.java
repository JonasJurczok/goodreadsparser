package org.linesofcode.goodreadsparser.scanner;

import org.linesofcode.goodreadsparser.Context;

public interface Scanner {

	boolean isApplicable(Context context);

	void apply(Context context);
}
