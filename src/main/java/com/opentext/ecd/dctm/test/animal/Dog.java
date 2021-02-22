package com.opentext.ecd.dctm.test.animal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Scanner;



public class Dog extends Animal {
	
	String name;	
	Size size;
	
	public Dog(String name) {
		this.name= name;
		size = Size.SMALL;
	}
	
	public Dog(Size size) {
		this.size= size;
		this.name = "default";
	}
	
	public Dog(String name, Size size) {
		this.name = name;
		this.size = size;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public String getName() {
		return name;
	}
	

	public void display(){
		System.out.println(name);		
	}
	
	public void displaySize(){
		System.out.println(size.getSize());		
	}
	
	public static class SimpleDogBuilder {
		
		private String dogname = "string";
		private Size dogSize;		
		
		
		
		public SimpleDogBuilder setDogName(String name) {
			this.dogname = name;
			return this;
		}
		
		public SimpleDogBuilder setDogSize(Size size) {
			this.dogSize = size;
			return this;
		}
		
		public Dog build() {
			return new Dog(dogname, dogSize);
		}
	}
	
	public static void main(String[] args) {
		
		Size size = Size.EXTRALARGE;		
		Dog dog = new Dog(size);
		dog.displaySize();
		
		EatService eat = new EatService(0, "dog");
		eat.canEat();
		System.out.println("list the methods ");		
	
		for (Method method:eat.getClass().getDeclaredMethods()) {			
			System.out.println(method.getName());			
		}
		
		
		GenericService service = new GenericService() {

			@Override
			public void canEat() {
				System.out.println("I can also eat");				
			}

			@Override
			public void canFly() {		
				
			}

			@Override
			public void canWalk() {				
				
			}
			
		};
		
		service.canEat();
	
	
	
//	try(Scanner scanner = new Scanner(new File("testRead.txt")); PrintWriter writer = new PrintWriter(new File("testWrite.txt"))){
//		while(scanner.hasNext()) {
//			writer.print(scanner.nextLine());
//		}
//	} catch (FileNotFoundException e) {		
//		e.printStackTrace();
//	}
	
	}
	
}
