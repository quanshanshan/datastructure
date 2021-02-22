package com.opentext.ecd.dctm.test.designpattern.factory;

import java.util.Scanner;

import com.opentext.ecd.dctm.test.animal.Animal;
import com.opentext.ecd.dctm.test.animal.Dog;
import com.opentext.ecd.dctm.test.animal.EatService;

public class SimpleFactory {
	
	public Animal getInstance(String type) {
		
		if(("Dog").equals(type)) {
			return new Dog("pony");
		}
		
		if(("EatService").equals(type)) {
			return new EatService(0, "cat");
		}
		return null;
		
	}
	
	
	public static void main(String[] args) {
		SimpleFactory factory = new SimpleFactory();
		
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
		System.out.println(factory.getInstance(scanner.next()).toString());
		}
		
			}

}
