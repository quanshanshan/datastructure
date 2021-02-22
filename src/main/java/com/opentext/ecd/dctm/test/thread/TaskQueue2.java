package com.opentext.ecd.dctm.test.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TaskQueue2 {
public static int count = 1;
	
	public Queue<String> list = new LinkedList<String>();
	//public Object objectMonitor = new Object();
	
	public synchronized void addTask(String task) {
		list.add(task);
		this.notify();
		
	}
		
		
	public synchronized static int getCount() {
		return count;
	}
	
	public synchronized String getTask() {
		
		while(list.isEmpty()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list.remove();
	}
	
	public static void main(String[] args) {
		TaskQueue2 queue = new TaskQueue2();
		List<Thread> list = new ArrayList<Thread>(5);
		
		for(int i=0; i< 5; i++) {
			Thread t = new Thread() {
				public void run() {
				String task;
				task = queue.getTask();
				System.out.println("get task " + task + " for "+ Thread.currentThread().getName());
				
				}
			};
			
			t.start();
			
			list.add(t);
		}
		
		Thread t1 = new Thread(()->{
			queue.addTask("task1");
			System.out.println("add task " + Thread.currentThread().getName());
		});
		
		t1.start();
		
		
		Thread t2 = new Thread(()->{
			queue.addTask("task1");
			System.out.println("add task " + Thread.currentThread().getName());
		});
		
		t2.start();
		
		
		Thread t3 = new Thread(()->{
			queue.addTask("task1");
			System.out.println("add task " + Thread.currentThread().getName());
		});
		
		t3.start();
		
		
		Thread t4 = new Thread(()->{
			queue.addTask("task1");
			System.out.println("add task " + Thread.currentThread().getName());
		});
		
		t4.start();
		
		Thread t5 = new Thread(()->{
			queue.addTask("task1");
			System.out.println("add task " + Thread.currentThread().getName());
		});
		
		t5.start();
		
	}
 
}
