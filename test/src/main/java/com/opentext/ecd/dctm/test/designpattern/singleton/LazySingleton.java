package com.opentext.ecd.dctm.test.designpattern.singleton;

public class LazySingleton {
	
	private static LazySingleton instance;
	
	private LazySingleton() {
		
	}
	
	public static LazySingleton getInstance() {
		
		if(instance==null) {
			instance = new LazySingleton();
		}
		return instance;
		
	}

}
