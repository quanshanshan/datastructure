package com.opentext.ecd.dctm.test.animal;

public class Cat extends Animal{
	
	String name;
	
	public Cat (String name) {
		this.name = name;
	}	
	

	@Override
	void display() {
		System.out.println("this is a cat");
		
	}

}
