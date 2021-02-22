package com.opentext.ecd.dctm.test.designpattern.singleton;

public class InnerClass {

	private InnerClass() {

	}

	static class InnerClass2 {
		private static InnerClass instance = new InnerClass();
	}

	public static InnerClass getInstance() {
		return InnerClass2.instance;
	}

}
