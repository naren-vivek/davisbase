package com.utdallas.db.davisbase.file;

import java.io.IOException;

public class LeafCell extends Cell {

	short totalPayload;
	int rowId;
	byte noOfColumns;
	byte[] colTypes;
	byte[][] columns;

	public void writeCell(TableFile file, long offset) throws IOException {
		file.seek(offset);
		file.writeShort(totalPayload);
		file.writeInt(rowId);
		file.writeByte(noOfColumns);
		file.write(colTypes);
		for (byte[] column : columns) {
			file.write(column);
		}
	}

}
