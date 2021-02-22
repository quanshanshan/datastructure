package com.opentext.ecd.dctm.test.thread;

import java.util.LinkedList;
import java.util.Queue;

public class WaitNotifyDemo {
	
	public static void main(String[] args) {
		
		Queue<String> list = new LinkedList<String>();
		int size = 10;
		
		Producer producer = new Producer(list, size);
		Consumer consumer = new Consumer(list, size);
		
		Thread t4 = new Thread(consumer);
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);
		Thread t3 = new Thread(consumer);
		
		t4.start();
		t1.start();
		t2.start();
		t3.start();
	
	  
		
		
	}

}
