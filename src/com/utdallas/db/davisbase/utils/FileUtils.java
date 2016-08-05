package com.utdallas.db.davisbase.utils;

import com.utdallas.db.davisbase.file.TableFile;

public class FileUtils {

	TableFile tableFile;

	// Used for all update operations
	// static TableFile davisTables = new TableFile("davis_tables.tbl", "rw");
	// static TableFile davisColumns = new TableFile("davis_columns", "rw");
	//
	// FileUtils davisTablesUtil;
	// FileUtils davisColumnsUtil;

	public void createTableFile(String fileName) {
		try {
			tableFile = new TableFile("data/" + fileName + ".tbl", "rw");
		} catch (Exception e) {
			System.err.println("Error while creating table file for " + fileName + ".");
			e.printStackTrace();
		}
	}

	public void writeToFile(Object[] record) {

	}

}
