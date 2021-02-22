package com.opentext.ecd.dctm.test.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
	
	
public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		
		TaskQueueCondition queue = new TaskQueueCondition(lock);
		List<Thread> list = new ArrayList<Thread>(5);
		
		for(int i=0; i< 5; i++) {
			Thread t = new Thread() {
				public void run() {
				String task;
				try {
					task = queue.getTask();
					System.out.println("get task " + task);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
			};
			
			t.start();
			
			list.add(t);
		}
		
		Thread t1 = new Thread(()->{
			queue.addTask("task1");
			System.out.println("add task");
		});
		
		t1.start();
		
		
		Thread t2 = new Thread(()->{
			queue.addTask("task1");
			System.out.println("add task");
		});
		
		t2.start();
		
		
		Thread t3 = new Thread(()->{
			queue.addTask("task1");
			System.out.println("add task");
		});
		
		t3.start();
		
		
		Thread t4 = new Thread(()->{
			queue.addTask("task1");
			System.out.println("add task");
		});
		
		t4.start();
		
		Thread t5 = new Thread(()->{
			queue.addTask("task1");
			System.out.println("add task");
		});
		
		t5.start();
		
	}

}
