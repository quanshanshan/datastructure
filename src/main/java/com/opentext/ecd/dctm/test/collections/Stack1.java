package com.opentext.ecd.dctm.test.collections;

public class Stack1 {
	
	int[] array;
	int cap;
	int size;
	
	
	Stack1(int number){
		this.cap = number;
		array = new int[number];
		size=0;
	}
	
	void push(int data) {
		if(size < cap) {
			array[++size] = data;			
		}else {
			return ;
		}
			
		
	}
	
	void pop() {
		if(size==0) {
			return;
		}
		
		size--;
		
	}

}
