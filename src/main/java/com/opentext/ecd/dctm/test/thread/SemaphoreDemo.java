package com.opentext.ecd.dctm.test.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		 Semaphore count = new Semaphore(5);	
		 for(int i =0; i < 10; i++) {
			 new Car(count, i).start();
		 }
		 
		 count.acquire();
		 count.release();
	}
	
	static class Car extends Thread{
		
		Semaphore phore;
		public Car(Semaphore phore, int num) {
			super();
			this.phore = phore;
			this.num = num;
		}


		int num;
		
	
		public void run() {
			try {
				phore.acquire();
				System.out.println("test " + num + " 占用一个令牌");
				Thread.sleep(2000);
				System.out.println("test " + num + " 释放一个令牌");
				phore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
