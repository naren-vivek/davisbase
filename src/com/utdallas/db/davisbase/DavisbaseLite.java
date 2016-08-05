package com.utdallas.db.davisbase;

import java.io.IOException;

import com.utdallas.db.davisbase.file.TableFile;

public class DavisbaseLite {

	public static void main(String[] args) throws IOException {
		TableFile tableFile = new TableFile("data/sample.tbl", "rw");

		tableFile.close();
	}

}
