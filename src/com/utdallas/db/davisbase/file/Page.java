package com.utdallas.db.davisbase.file;

import java.io.IOException;
import java.util.Iterator;

import com.utdallas.db.davisbase.constants.Config;

public class Page {

	int pageNo;
	PageHeader header;
	TableFile tableFile;
	short[] contentOffsets;

	public Page(int pageNo, TableFile tableFile) throws IOException {
		super();
		this.pageNo = pageNo;
		this.tableFile = tableFile;
		this.header = new PageHeader(pageNo, this.tableFile);
		this.contentOffsets = new short[Config.MAX_BTREE_NODES];

		// TODO handle seek exception
		this.tableFile.seek(header.cellPointerOffset);

		for (byte i = 0; i < header.noOfCells; i++) {
			this.contentOffsets[i] = this.tableFile.readShort();
		}
	}

	/*
	 * Iterator for Page. Iterates through each cell in the page
	 * 
	 */
	private class Itr implements Iterator<Cell> {

		short currentCell = 0;
		short totalCells = header.noOfCells;

		@Override
		public boolean hasNext() {
			return currentCell < totalCells;
		}

		@Override
		public Cell next() {
			long offset = ((pageNo - 1) * Config.PAGE_SIZE) + contentOffsets[currentCell++];

			// Read the cell data

			return null;
		}

	}

}
