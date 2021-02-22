package com.opentext.ecd.dctm.test.animal;


public class EatService extends Animal implements GenericService {
	
	int number;	
	String name;
	
	public EatService(int number, String name) {		
		this.number = number;
		this.name = name;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public void canEat() {
		System.out.println("I can eat " + number);

	}

	@Override
	public void canFly() {
		System.out.println("I cannot fly");

	}

	@Override
	public void canWalk() {
		System.out.println("I cannot walk");

	}
	
	
	public void display() {
		System.out.println(name);
		System.out.println(number);
		
	}

}
