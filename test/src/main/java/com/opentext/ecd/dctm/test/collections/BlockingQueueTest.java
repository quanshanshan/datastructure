package com.opentext.ecd.dctm.test.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {
	
	public static void main(String[] args) {
		
	BlockingQueue<String> bq= new ArrayBlockingQueue<String>(100);
	bq.add("c");
	bq.add("b");
	bq.add("a");
	
	for(String a: bq) {
		System.out.println(a);
	}
	
	BlockingQueue<String> lbq = new LinkedBlockingQueue<String>();
	lbq.add("c");
	lbq.add("b");
	lbq.add("a");
	for(String a: lbq) {
		System.out.println(a);
	}
	
	
	}
}
