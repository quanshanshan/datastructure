package com.opentext.ecd.dctm.test.thread;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.opentext.ecd.dctm.test.thread.ThreadPoolDemo.NewThreadFactory;

public class MyThreadPool extends ThreadPoolExecutor{
	
	public Set<Runnable> tasks = new HashSet<>();
	public Set<Runnable> rejectedTasks = new HashSet<>();

	public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, NewThreadFactory newThreadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,newThreadFactory, rejectedExecutionHandler );
	}
	public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, NewThreadFactory newThreadFactory) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,newThreadFactory );
	}
	
	
  public void beforeExecute(Thread t, Runnable r) {
	  synchronized(tasks) {
		  tasks.add(r);
	  }
  }
  
  public void afterExecute(Runnable r, Throwable t) {
	  synchronized(tasks) {
		  tasks.remove(r);
	  }
  }
  
   public class MyRunPolicy  implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("add to rejested tasks");
		rejectedTasks.add(r);
		
	}
	  
  }

}
