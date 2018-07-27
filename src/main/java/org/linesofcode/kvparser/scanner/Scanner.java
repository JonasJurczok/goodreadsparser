package org.linesofcode.kvparser.scanner;

import org.linesofcode.kvparser.Context;

public interface Scanner {

	boolean isApplicable(Context context);

	void apply(Context context);
}
