package com.opentext.ecd.dctm.test.thread;

public class JoinDemo  {
	
	 static int i = 0;
	
	public static void main(String[] args) throws InterruptedException {
		
		
		Thread t = new Thread(()->{
			
			while(i<100) {
			 i+=10;
			
			 try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			}
		});
		
		t.start();
		
		t.join(); // 线程的执行结果对调用线程可见
		
		System.out.println(i);
	}

}
