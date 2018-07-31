package org.linesofcode.goodreadsscraper;

import com.opencsv.bean.CsvBindByPosition;

public class Type {

	@CsvBindByPosition(position = 0)
	private String type;

	@CsvBindByPosition(position = 1)
	private String displayName;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
