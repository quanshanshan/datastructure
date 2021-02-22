package com.opentext.ecd.dctm.test.thread;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TaskQueueCondition {

	public Queue<String> tasks = new LinkedList<String>();
	public ReentrantLock lock;
	public Condition condition;

	public TaskQueueCondition(ReentrantLock lock) {
		this.lock = new ReentrantLock();
		this.condition = lock.newCondition();
	}

	public String getTask() throws InterruptedException {
		this.lock.lock();
		try {
			while (tasks.isEmpty()) {
				this.condition.await();
			}

			return tasks.remove();

		} finally {
			this.lock.unlock();
		}

	}

	public void addTask(String task) {
		this.lock.lock();
		try {
			tasks.add(task);
			this.condition.signalAll();
		} finally {
			this.lock.unlock();
		}
	}

}
