package com.opentext.ecd.dctm.test.thread;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class LockDemo {
	
	public static Map<String, Object> cachemap = new HashMap<String, Object>();
	
	public final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	final ReadLock rlock = lock.readLock();	
	final WriteLock wlock = lock.writeLock();
	
	public static Queue<String> tasks;
	
	static {
		tasks  = new LinkedList<String>();
	}
	
	public void addTask(String task, Object object) {
		wlock.lock();
		try {		
			tasks.add(task);
			cachemap.put(task, object);
		}finally {
			wlock.unlock();
		}
		
	
	}
	
	public String getTask() {
		rlock.lock();
		try {		
		String task = tasks.remove();
		cachemap.get(task);
		
		return task;
		}finally {
		rlock.unlock();
		}
		
	}

}
