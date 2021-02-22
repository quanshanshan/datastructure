package com.opentext.ecd.dctm.test.thread;

import java.util.concurrent.atomic.AtomicLong;

public class IDGenerator {
	
	public  AtomicLong id = new AtomicLong(0);
	
	public void generateId() {
		id.getAndIncrement();
		System.out.println(id.get());
	}
	
	public static void main(String[] args) {
		IDGenerator idgenerator = new IDGenerator();
		idgenerator.generateId();
		idgenerator.generateId();
		
		Thread t = new Thread(()->{
			idgenerator.generateId();
		});
		
		t.start();
		
		
		Thread t1 = new Thread(()->{
			idgenerator.generateId();
		});
		
		t1.start();
		

		Thread t2 = new Thread(()->{
			idgenerator.generateId();
		});
		
		t2.start();
	}

}
