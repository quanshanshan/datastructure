package com.opentext.ecd.dctm.test.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ThreadPoolDemo implements Runnable{
	
	public static void main(String[] args) throws InterruptedException {
		Executors.newSingleThreadExecutor();
		Executors.newCachedThreadPool();
		ExecutorService service = Executors.newFixedThreadPool(3);
		ScheduledExecutorService service1 = Executors.newScheduledThreadPool(3);
		
		
		
		
		for(int i =0; i< 100; i++) {
			service.execute(new ThreadPoolDemo());
		}
		
		Thread.sleep(4000);
		service.shutdownNow();
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
