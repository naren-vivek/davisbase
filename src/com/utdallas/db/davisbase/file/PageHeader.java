package com.utdallas.db.davisbase.file;

import com.utdallas.db.davisbase.constants.Config;
import com.utdallas.db.davisbase.constants.PageType;

public class PageHeader {

	byte pageType;
	byte noOfCells;
	short cellContentOffset;
	long cellPointerOffset;
	int rightPtr; // Points to right most page from interior cell
	int pageNo;
	int size;

	TableFile tableFile;

	public PageHeader(int pageNo, TableFile tableFile) {
		super();
		this.pageNo = pageNo;
		this.tableFile = tableFile;

		int pageOffset = Config.PAGE_SIZE * (pageNo - 1);
		if (this.pageNo == 1)
			pageOffset += Config.FILE_HEADER_SIZE;

		try {
			this.tableFile.seek(pageOffset);
			this.pageType = this.tableFile.readByte();
			this.noOfCells = this.tableFile.readByte();
			this.cellContentOffset = this.tableFile.readShort();
			if (this.pageType == PageType.INTERIOR_PAGE) {
				this.rightPtr = this.tableFile.readInt();
			}
			this.cellPointerOffset = this.tableFile.getFilePointer();
		} catch (Exception e) {
			System.err.println("Error while reading page no " + pageNo);
			e.printStackTrace();
		}
	}

}
