package com.opentext.ecd.dctm.test.thread;


import java.util.concurrent.TimeUnit;

import org.springframework.util.StopWatch;

public class ThreadDemo extends Thread {
	
	public static volatile boolean isStop; 
	
	@Override
	public void run() {
		
		StopWatch clock = new StopWatch();
		clock.start();
		
		
		while(!isStop) {
		System.out.println(Thread.currentThread().getName());
	}
		
		clock.stop();
		
		System.out.println("total run time "+ clock.getTotalTimeSeconds());
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread demo  = new ThreadDemo();
		//demo.setDaemon(true);
		demo.start();
		TimeUnit.SECONDS.sleep(1);
		ThreadDemo.isStop = true;
		
		
	}
	

}
