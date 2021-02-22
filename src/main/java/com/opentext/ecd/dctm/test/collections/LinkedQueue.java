package com.opentext.ecd.dctm.test.collections;

public class LinkedQueue {

	Node head;
	Node tail;

	class Node {
		int data;

		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	void linkedQueue() {
		head = null;
		tail = null;
	}

	void add(int data) {
		if(head==null) {
			head = new Node(data);
			tail=head;
		}else {
			tail.next = new Node(data);
			tail=tail.next;
		}
		

	}
	
	void remove() {
		if(head==tail) {
			head=null;
			tail=null;
		}else {
			head=head.next;
		}
	}

}
