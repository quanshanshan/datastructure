package com.opentext.ecd.dctm.test.thread.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserService {

	ExecutorService service = Executors.newSingleThreadExecutor();

	BlockingQueue<User> queue = new ArrayBlockingQueue<User>(10);	
	
	public volatile boolean stop = false;
	
	{
		init();
	}

	public  void init() {

		service.execute(() -> {
			while (!stop) {
				try {
					User user = queue.take();
					System.out.println("发送优惠券");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Thread.currentThread().interrupt();
				}

			}
		});
	}
	
	public boolean register(User user) throws InterruptedException {
		
		addUser(user);
		queue.put(user);
		
		return true;
	}
	public void addUser(User user) {
		System.out.println("add a user");
		
	}
	
	public void shutdown() {
		System.out.println("shut down");
		stop = true;
		service.shutdownNow();
		System.out.println("complete shut down");		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		UserService userSvc = new UserService();
		User user = new User("sherry");
		userSvc.register(user);
		Thread.sleep(1000);
		user = new User("Michael");
		userSvc.register(user);
		
		Thread.sleep(1000);
		userSvc.shutdown();
		
	}
	
	

}
