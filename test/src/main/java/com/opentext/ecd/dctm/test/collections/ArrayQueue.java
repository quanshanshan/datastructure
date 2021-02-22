package com.opentext.ecd.dctm.test.collections;

public class ArrayQueue {

	int[] array;	
	int size;	
	int head;
	int tail;
	
	ArrayQueue(int size){
		this.size =size;
		array = new int[size];		
	}
	
	boolean add(int data) {
		if(tail==size) return false;		
		array[tail]=data;
		++tail;
		return true;
		
	}
	
	int remove() {
		
		if(head==tail) return 0;		
		int data = array[head];
		++head;
		return data;
		
	}
	
	
}
