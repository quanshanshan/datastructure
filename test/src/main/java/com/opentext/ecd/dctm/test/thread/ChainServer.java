package com.opentext.ecd.dctm.test.thread;

public class ChainServer {
	
	private RequestProcessor firstProcessor;
	
	public void setupRequestProcessor() {
		RequestProcessor processor = new FinalRequestProcessor();
		RequestProcessor saveProcessor = new SaveProcessor(processor);
		firstProcessor = new PrintProcessor(saveProcessor);
		((FinalRequestProcessor)processor).start();
		((SaveProcessor)saveProcessor).start();
		((PrintProcessor)firstProcessor).start();
		
		
	}
	
	public void startup() {
		this.setupRequestProcessor();
	}
	
	public void shutdown() {
		firstProcessor.shutdown();
	}
	
	public static void main(String[] args) throws InterruptedException {
		ChainServer server = new ChainServer();
		server.startup();		
		Request request = new Request(5, "test");
		server.firstProcessor.processRequest(request);		
		Thread.sleep(10000);		
		server.shutdown();
	}

}
