package com.utdallas.db.davisbase.file;

import java.io.IOException;

public class LeafCell extends Cell {

	short totalPayload;
	int rowId;
	byte noOfColumns;
	byte[] colTypes;
	byte[][] columns;

	public void writeCell(TableFile tableFile, long offset) throws IOException {
		tableFile.seek(offset);
		tableFile.writeShort(totalPayload);
		tableFile.writeInt(rowId);
		tableFile.writeByte(noOfColumns);
		tableFile.write(colTypes);
		for (byte[] column : columns) {
			tableFile.write(column);
		}
	}

	@Override
	public Cell readCell(TableFile tableFile, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

}
