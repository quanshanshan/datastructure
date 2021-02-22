package com.opentext.ecd.dctm.test.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FinalRequestProcessor extends Thread implements RequestProcessor{
	
	volatile boolean finished = false;

	BlockingQueue<Request> requests = new LinkedBlockingQueue<Request>();

	@Override
	public void processRequest(Request request) {
		requests.add(request);
	}

	@Override
	public void shutdown() {
		System.out.println("final processor shutdown");
		finished = true;
		requests.clear();
		System.out.println("final processor shutdown completes");
	}
	
	@Override
	public void run() {
		while (!finished) {
			try {
				Request request = requests.take();
				System.out.println("final request " + request);			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}



