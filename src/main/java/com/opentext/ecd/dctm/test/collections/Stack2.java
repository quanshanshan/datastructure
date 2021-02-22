package com.opentext.ecd.dctm.test.collections;

public class Stack2 {
	Node head;
	
	class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;			
		}
		
		
	}
	
	void push(int data) {
		
		Node p = head;
		
		while(p.next !=null) {
			p=p.next;
		}
		
		 Node node = new Node(data);
		 p.next=node;
		 
	}
	
	void pop() {
		Node p = head;
		if(p.next==null) {
			head=null;
			return;
		}
		
		while(p.next.next!=null) {
			p=p.next;
		}
		p.next=null;
	}	

//	    public boolean isValid(String s) {
//	        Stack s1= new Stack(s1.size);
//	        for(char c: s.toCharArray()) {
//	        	if(isleft(c)) {
//	        		s1.push(data);
//	        	}
//	        	
//	        	if(isright(c)) {
//	        		pop();
//	        	}
//	        }

	   
public static void main(String[] args) {
	
	Stack1 s = new Stack1(100);
	s.push(10);
	s.push(20);
}


		
}