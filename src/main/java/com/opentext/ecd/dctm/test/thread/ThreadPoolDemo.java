package com.opentext.ecd.dctm.test.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.opentext.ecd.dctm.test.thread.MyThreadPool.MyRunPolicy;

public class ThreadPoolDemo implements Runnable{
	
	static class NewThreadFactory implements ThreadFactory{	
		
		String name;
		public AtomicInteger number = new AtomicInteger(0);
		
		public NewThreadFactory(String name) {
			this.name = name;
		}

		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r, this.name + "-" + number.getAndIncrement());
			return t;
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);		

		MyThreadPool pool = new MyThreadPool(4, 4, 0, TimeUnit.SECONDS, queue, new NewThreadFactory("my"));
		
		pool.setRejectedExecutionHandler(pool.new MyRunPolicy() );
	
		
		
//		ExecutorService service = Executors.newFixedThreadPool(4, new NewThreadFactory("test"));
//	
//		
//		Executors.newScheduledThreadPool(3, new NewThreadFactory("test"));
		for(int i=0; i< 8; i++) {
		
		pool.execute(new ThreadPoolDemo() );
		}
		
		Thread.sleep(1000);
		ThreadDemo.isStop = true;
		pool.shutdown();
	}

	@Override
	public void run() {
		System.out.println("test");		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
