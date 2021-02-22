package com.opentext.ecd.dctm.test.designpattern.singleton;

public class ThreadTest {
	
	public static void main(String[] args) {
	
	EexcThread t1 = new EexcThread();
	EexcThread t2 = new EexcThread();
	
	t1.start();
	t2.start();
	
	
	}

}
