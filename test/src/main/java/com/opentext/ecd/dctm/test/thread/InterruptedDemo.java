package com.opentext.ecd.dctm.test.thread;

import org.openjdk.jol.info.ClassLayout;

public class InterruptedDemo {

	public static int count = 0;

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				System.out.println("running");
				try {
					Thread.sleep(1000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Thread.currentThread().interrupt();
				}
			}

		});

//	t.start();
//	
//	Thread.sleep(1000);
//	t.interrupt();

//	Thread t1 =	 new Thread(()->{
//		
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//			
//		});
//	
//	t1.start();
//	
//	t1.interrupt();

		InterruptedDemo demo = new InterruptedDemo();
		Thread t1 = new Thread(() -> {
			synchronized (demo) {
				System.out.println(ClassLayout.parseInstance(demo).toPrintable());
			}
		});

		t1.start();

		synchronized (demo) {
			System.out.println(ClassLayout.parseInstance(demo).toPrintable());
		}

	}

}
