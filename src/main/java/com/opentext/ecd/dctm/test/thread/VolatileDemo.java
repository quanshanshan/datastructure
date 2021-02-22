package com.opentext.ecd.dctm.test.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileDemo {
	
	public static volatile boolean stop = false;
	
	public static volatile int count=0;
	public static AtomicInteger size = new AtomicInteger(0);
	
	public static Lock lock = new ReentrantLock(); 
	
	public static void incWithLock()  {
		lock.lock();
		try {
		
		count++;
		
		Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public static void dec() {
		lock.lock();
		try {		
		count--;		
		Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public static void inc()  {	
		
		size.getAndIncrement();	
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(()->{
			
			int i = 0;
			while(!stop) {
				
				i++;
				//count++;
				//System.out.println("name");
			}
			
		});
		
		t.start();
		
		Thread.sleep(1000);
		
		stop = true;
		
		for(int i =0; i< 1000; i++) {
		new Thread(()->VolatileDemo.inc()).start();
		}
		
		Thread.sleep(4000);
		System.out.println(count); 
		System.out.println(size.get()); 
	}

}
