package com.utdallas.db.davisbase.constants;

public class Config {
	public static int PAGE_SIZE = 512;
	public static int FILE_HEADER_SIZE = 8;
	public static int LEAF_PAGE_HEADER_SIZE = 4;
	public static int INTERIOR_PAGE_HEADER_SIZE = 8;
	
	
	public static int MAX_BTREE_NODES = (PAGE_SIZE - FILE_HEADER_SIZE) / 10;
}
