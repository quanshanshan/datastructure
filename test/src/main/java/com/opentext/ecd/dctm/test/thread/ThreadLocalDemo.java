package com.opentext.ecd.dctm.test.thread;

public class ThreadLocalDemo {
	
	public static ThreadLocal<String> local = new ThreadLocal<String>();
	public static ThreadLocal<String> local2 = new ThreadLocal<String>();
	public static String abc = "abc";
	public static int count =0;
	public static volatile int size=0;
	
	public static void main(String[] args) {
		for(int i=0; i< 5; i++) {
			Thread t = new Thread(()->{
				count++;
				size++;
				local.set(Thread.currentThread().getName());				
				System.out.println(local.get());			
				
				local2.set("it's me");
				System.out.println(local2.get());
			
//				System.out.println(count);
//				System.out.println(size);
			});
			
			t.start();
		}
	}

}
