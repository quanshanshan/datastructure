package com.opentext.ecd.dctm.test.designpattern.singleton;



public class Lazy2 {

	private static Lazy2 instance;

	private Lazy2() {

	}

	synchronized public static  Lazy2 	getInstance() {
		
		if(instance==null) {
			instance = new Lazy2();
		}
		return instance;
		
	}

}
