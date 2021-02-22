package com.opentext.ecd.dctm.test.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class RunnableDemo implements Runnable{
	public static AtomicInteger total = new AtomicInteger(10);

	@Override
	public void run() {
		while(total.get() >0){			
			System.out.println(Thread.currentThread().getName());
			System.out.println(total.get());
			total.getAndDecrement();
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Runnable demo1 = new RunnableDemo();
		Thread demothread = new Thread(demo1);		
		Runnable demo2 = new RunnableDemo();
		Thread demothread1 = new Thread(demo2);
		demothread.start();
		demothread1.start();
	}

}
