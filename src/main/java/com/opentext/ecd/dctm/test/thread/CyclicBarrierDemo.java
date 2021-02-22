package com.opentext.ecd.dctm.test.thread;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo extends Thread{
	
	public void run() {
		System.out.println("汇总");
	}
	
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3,new CyclicBarrierDemo() );
		DataImportThread t1 = new DataImportThread("1", barrier);
		DataImportThread t2 = new DataImportThread("2", barrier);
		DataImportThread t3 = new DataImportThread("3", barrier);
		t1.start();
		t2.start();
		t3.start();
	}

}
