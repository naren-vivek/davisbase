package com.utdallas.db.davisbase.file;

import java.io.IOException;
import java.util.Iterator;

import com.utdallas.db.davisbase.constants.Config;

public class Page implements Iterator<Page> {

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

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page next() {
		// TODO Auto-generated method stub
		return null;
	}

}
