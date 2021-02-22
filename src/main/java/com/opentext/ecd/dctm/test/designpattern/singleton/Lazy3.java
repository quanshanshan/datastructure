package com.opentext.ecd.dctm.test.designpattern.singleton;

public class Lazy3 {
	private static Lazy3 instance;

	private Lazy3() {

	}

	public static Lazy3 getInstance() {

		if (instance == null) {
			synchronized (Lazy3.class) {
				if (instance == null) {
					instance = new Lazy3();
				}
			}
		}
		return instance;

	}

}
