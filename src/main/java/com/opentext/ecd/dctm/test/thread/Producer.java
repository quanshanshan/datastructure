package com.opentext.ecd.dctm.test.thread;


import java.util.Queue;

public class Producer implements Runnable{
	
	public Queue<String> list;
	public int size;
	
	public Producer(Queue queue, int size) {
		this.list = queue;
		this.size = size;
		
	}

	@Override
	public void run() {
		int i =0;
		while(true) {
			i++;
			synchronized(list) {
				while(list.size() == size) { // queue 满了
					System.out.println("queue is full");
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
				
				list.add("bag" + i);
				System.out.println("add a bag " + i);
				list.notify();
			}
		}
		
	}

}
