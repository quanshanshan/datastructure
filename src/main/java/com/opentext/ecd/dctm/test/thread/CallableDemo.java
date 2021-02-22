package com.opentext.ecd.dctm.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class CallableDemo implements Callable<String> {
	
	private static int count;

	@Override
	public String call() throws Exception {
		return Thread.currentThread().getName();
	}

	static class CustomizedThreadFactory implements ThreadFactory {

		private final String namePrefix;
		private final AtomicInteger threadNumber = new AtomicInteger();

		public CustomizedThreadFactory(String namePrefix) {
			this.namePrefix = namePrefix;

		}

		@Override
		public Thread newThread(Runnable r) {
			Thread thread = new Thread(r, namePrefix + "-" + threadNumber.getAndIncrement());

			thread.setPriority(2);

			return thread;
		}

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService scheduler = Executors.newFixedThreadPool(10, new CustomizedThreadFactory("test"));
		int i = 0;
		while (i < 10) {
			Future<String> future = scheduler.submit(new CallableDemo());
			System.out.println(future.get());
			i++;
		}
		scheduler.shutdown();
		
		
		Thread t1 = new Thread(()->{
			while(count<5) {
				System.out.println(count + " " +  Thread.currentThread().getName());
			count++;
			}
			try {
				Thread.sleep(1000);
				Thread.yield();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		});
		
		Thread t2 = new Thread(()->{
			while(count<5) {
				System.out.println(count +" " +  Thread.currentThread().getName());
			count++;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		t1.start();
		t1.join();
		t2.start();
		

	}

}
