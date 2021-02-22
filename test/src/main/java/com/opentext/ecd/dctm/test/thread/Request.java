package com.opentext.ecd.dctm.test.thread;

public class Request {
	
	int id;

	String name;
	
	public Request(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", name=" + name + "]";
	}

}
