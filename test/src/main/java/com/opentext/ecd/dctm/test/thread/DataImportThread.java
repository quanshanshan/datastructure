package com.opentext.ecd.dctm.test.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class DataImportThread extends Thread{
	
	String path;
	CyclicBarrier barrier;
	
	public DataImportThread(String path, CyclicBarrier barrier) {		
		this.path = path;
		this.barrier = barrier;		
	}

	@Override
	public void run() {
		System.out.println(path);
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
