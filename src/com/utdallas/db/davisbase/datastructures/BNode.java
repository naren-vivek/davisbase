package com.utdallas.db.davisbase.datastructures;

public class BNode {

	int m; // Number of keys
	int[] key; // Array of keys (Row id)
	BNode[] child; // Array of pointers
	BNode parent;  
	int keyCount;
	
	// Additional data for the table files
	int pageNo;
	boolean updated;
	
}
