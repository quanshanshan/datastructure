package com.opentext.ecd.dctm.test.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
		
		queue.put("test");
		queue.take();
		
		
	}

}
