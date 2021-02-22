package com.opentext.ecd.dctm.test.jvm;

public class InitializationDemo {
	
	public static int a =0;
	public final static String abc= "abc";
	
	static {
		System.out.println("parent init");
	}
	
	
	
}
	
	class Child extends InitializationDemo{
		
		static {
			System.out.println("child init");
		}
	}

	


