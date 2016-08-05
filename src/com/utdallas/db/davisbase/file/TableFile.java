package com.utdallas.db.davisbase.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.utdallas.db.davisbase.constants.Config;
import com.utdallas.db.davisbase.constants.PageType;
import com.utdallas.db.davisbase.datastructures.BTree;

public class TableFile extends RandomAccessFile {

	BTree btree;
	FileHeader fileHeader;

	public TableFile(String name, String mode) throws IOException {
		super(name, mode);
		initialize();
	}

	public TableFile(File file, String mode) throws IOException {
		super(file, mode);
		initialize();
	}

	public void initialize() throws IOException {
		// Handling creation of header for new table
		if (this.length() == 0) {
			// Creating page of size 1
			this.setLength(Config.PAGE_SIZE);

			// Writing file header
			this.writeInt(1);
			this.writeInt(1);

			// Writing page header for 1st page (Leaf node)
			this.writeByte(PageType.LEAF_PAGE);
			this.writeByte(0);
			this.writeShort(0);

			System.out.println("Created a new File...");
		}

		// Load the Header for current TableFile
		this.loadHeader();

		// Loading BTree for current table
		if (this.length() == Config.PAGE_SIZE) {
			btree = null;
		} else {
			loadBTree();
		}
	}

	public void loadHeader() {
		fileHeader = new FileHeader(this);
		System.out.println("loadHeader : ");
		System.out.println(fileHeader);
	}

	public void loadBTree() {

	}

}
