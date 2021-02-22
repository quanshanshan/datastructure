package com.opentext.ecd.dctm.test.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo implements Runnable{
	
	static CountDownLatch countdownlatch = new CountDownLatch(1);
	
	public static void main(String[] args) throws InterruptedException {	
	
	CountDownLatch latch = new CountDownLatch(3);
	
	new Thread(()->{
		System.out.println(Thread.currentThread().getName() + "->begin");
		latch.countDown();
		System.out.println(Thread.currentThread().getName() + "->end");
	}, "t1").start();
	
	new Thread(()->{
		System.out.println(Thread.currentThread().getName() + "->begin");
		latch.countDown();
		System.out.println(Thread.currentThread().getName() + "->end");
	}, "t2").start();
	
	new Thread(()->{
		System.out.println(Thread.currentThread().getName() + "->begin");
		latch.countDown();
		System.out.println(Thread.currentThread().getName() + "->end");
	}, "t3").start();
	
	latch.await();
	
	System.out.println("end");
	
	for(int i =0; i < 100; i++) {
		new Thread(new CountDownLatchDemo()).start();
	}
	
	countdownlatch.countDown();
	
	}

	@Override
	public void run() {
		
		
		try {
			countdownlatch.await();
			System.out.println("start to run");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		
		
	}

}
