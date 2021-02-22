package com.opentext.ecd.dctm.test.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;
import java.util.Collection;

import com.opentext.ecd.dctm.test.animal.Dog;

public class ArrayListTest<E> {
	
	ArrayList<Dog> list = new ArrayList<Dog>();	
	
	public static void main(String[] args) {
		
		Collection<Dog> col = new ArrayList<Dog>();
		String[] newdog = new String[10];
		System.out.println(Dog.class);
		ArrayList<String> dogs = new ArrayList<String>(100);
		dogs.add("a");
		dogs.add("b");
		dogs.add("c");
		System.out.println(dogs);
		dogs.add(1, "e");
		dogs.set(1, "b");
		dogs.toArray(newdog);
		ArrayList<String> sec = new ArrayList<>(Arrays.asList(newdog));
		System.out.println(sec);
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c")) ;
		System.out.println(list);
		
		Vector<String> vector = new Vector<String>(10);
		System.out.println("capa " + vector.capacity() + "size" + vector.size());
		
		
		
		
		
	
	int[] abc = new int[10];
	Dog[] dog = new Dog[2];	
	
	dog[0] = new Dog("wawa");
	dog[1] = new Dog("baba");
	
	
	}
	
	

}
