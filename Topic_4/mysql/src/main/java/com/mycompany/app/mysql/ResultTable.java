package com.mycompany.app.mysql;

import java.util.ArrayList;
import java.util.List;

public class ResultTable {
	List<ResultRow> rows = new ArrayList<ResultRow>();

	public List<ResultRow> getRows() {
		return rows;
	}

	public void addRow(ResultRow row) {
		rows.add(row);
	}
	
}
