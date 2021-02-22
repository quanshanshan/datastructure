package com.opentext.ecd.dctm.test.thread.blockingqueue;

import java.io.Serializable;

public class User implements Serializable{
	
	String name;

	public User(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	

}
