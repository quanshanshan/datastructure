package com.opentext.ecd.dctm.test.thread;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
	
	static ConcurrentHashMap<String, String> map = new ConcurrentHashMap();
	
	public void addData(String a, String b) {
		
		map.put(a, b);		
		
	}
	
	public static void main(String[] args) {
		map.put("a", "b");
		map.put("b", "c");
		System.out.println(Integer.numberOfLeadingZeros(10));
	}
	
	

}
