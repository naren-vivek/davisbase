package com.utdallas.db.davisbase.file;

import java.io.IOException;

public class FileHeader {

	int noOfPages;
	int rootPage;
	int nextRowId;
	TableFile tableFile;

	static int size = 8;

	public FileHeader(TableFile tableFile) {
		super();
		this.tableFile = tableFile;
		try {
			this.tableFile.seek(0);
			this.noOfPages = this.tableFile.readInt();
			this.rootPage = this.tableFile.readInt();
		} catch (Exception e) {
			System.err.println("Error while reading table file.");
			e.printStackTrace();
		}

	}

	public boolean incrementRowIdAndSave() {
		this.nextRowId++;
		return updateFileHeader();
	}

	public boolean updateFileHeader() {

		try {
			tableFile.seek(0);
			tableFile.writeInt(rootPage);
			tableFile.writeInt(noOfPages);
			tableFile.writeInt(nextRowId);
			return true;
		} catch (IOException e) {
			System.err.println("Error while updating file header.");
			return false;
		}

	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public int getRootPage() {
		return rootPage;
	}

	public void setRootPage(int rootPage) {
		this.rootPage = rootPage;
	}

	@Override
	public String toString() {
		return "FileHeader [noOfPages=" + noOfPages + ", rootPage=" + rootPage + "]";
	}

}
