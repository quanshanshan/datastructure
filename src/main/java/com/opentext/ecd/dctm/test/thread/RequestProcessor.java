package com.opentext.ecd.dctm.test.thread;

public interface RequestProcessor {
	
	void processRequest(Request request);
	
    void shutdown();
}
