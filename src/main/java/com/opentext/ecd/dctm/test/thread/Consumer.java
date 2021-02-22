package com.opentext.ecd.dctm.test.thread;

import java.util.Queue;

public class Consumer implements Runnable{
	
	public Queue<String> list;
	public int size;
	
	public Consumer(Queue queue, int size) {
		this.list = queue;
		this.size = size;
		
	}

	@Override
	public void run() {
		while(true) {
			synchronized(list) {
				while(list.isEmpty()) {
					System.out.println("queue is empty");
					try {						
						list.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					String bag = list.remove();
					System.out.println("remove a bag " + bag);
					list.notify();
				}
			
		}
		
	}

}
