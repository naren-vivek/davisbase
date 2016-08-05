package com.utdallas.db.davisbase.file;

import java.io.IOException;

public abstract class Cell {

	public abstract void writeCell(TableFile tableFile, long offset) throws IOException;

	public abstract Cell readCell(TableFile tableFile, long offset) throws IOException;

}
