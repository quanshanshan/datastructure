package com.opentext.ecd.dctm.test.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PrintProcessor extends Thread implements RequestProcessor {

	RequestProcessor nextProcessor;
	
	volatile boolean finished = false;

	BlockingQueue<Request> requests = new LinkedBlockingQueue<Request>();

	public PrintProcessor(RequestProcessor nextProcessor) {
		this.nextProcessor = nextProcessor;

	}

	@Override
	public void processRequest(Request request) {
		requests.add(request);

	}

	@Override
	public void shutdown() {
		System.out.println("print processor shutdown");
		finished = true;
		requests.clear();
		nextProcessor.shutdown();
		System.out.println("print processor shutdown completes");

	}

	@Override
	public void run() {
		while (!finished) {
			try {
				Request request = requests.take();
				System.out.println("print request " + request);
				nextProcessor.processRequest(request);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
