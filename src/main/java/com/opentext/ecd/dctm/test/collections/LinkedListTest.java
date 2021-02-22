package com.opentext.ecd.dctm.test.collections;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class LinkedListTest {

	Node head;

	static class Node {
		int item;
		Node next;

		Node(int item, Node next) {
			this.item = item;
			this.next = next;
		}

		Node(int item) {
			this.item = item;		
		}

	}

	//add a node to the end of the queue
	public void addElement(int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node p = head;
			while (p.next != null) {
				p = p.next;
			}
			p.next = new Node(data);
		}

	}

	public void addPosition(int pos) {

	}

	
	// use 2 pointers, one moves one step, the other moves 2 steps each time, and it they can meet, there is a loop
	public boolean checkLoop() {
		Node p = head;
		Node q = head;
		while (p != null && p.next != null) {
			p = p.next.next;
			q = q.next;
			if (p == q) {
				return true;
			}
		}
		return false;

	}

	//remove the jth element
	public void remove(int j) {
		Node p = head;

		for (int i = 0; p != null && i < j - 1; i++) {
			p = p.next;
		}
		if (p == null || p.next == null) {
			return;
		}

		Node node = p.next.next;
		p.next = node;

	}

	//2 pointers, one moves one step, the other moves 2 steps
	public int findMiddle() {

		Node p = head;
		Node q = head;

		while (p != null) {
			p = p.next;
			if (p != null) {
				p = p.next;
				q = q.next;
			}
		}

		return q.item;

	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		LinkedListTest abc = new LinkedListTest();
		Node a = new Node(0);
		Node b = new Node(1);
		Node c = new Node(2);

		abc.head = a;
		a.next = b;
		b.next = c;

		Node p = abc.head;
		

		abc.addElement(6);
		abc.addElement(7);
		abc.addElement(8);	
		


		System.out.println(abc.findMiddle());
		System.out.println(abc.checkLoop());
		System.out.println(abc.reverse());
		
		
//		LinkedList<String> ldogs= new LinkedList<String>();
//		ldogs.add("a");
//		ldogs.add("b");
//		ldogs.add("c");
//		System.out.println(ldogs.size());
//		ldogs.add(1, "e");
//
//		
//		ObjectOutputStream  stream = new ObjectOutputStream(new FileOutputStream("C:/work/file.out"));
//		stream.writeObject(ldogs);
		
	}
	
	
	public Node reverse() {
		if(head==null) {
			return null;
		}
		Node prev = head;
		Node current = head.next;		
		prev.next=null;
		
		while(current!=null) {
			Node next = current.next;
			current.next=prev;
			prev=current;
			current=next;
			
		}
		//
		while (prev != null) {
			System.out.println(prev.item);
			prev = prev.next;
		}
		
		return prev;
	}
	
	public Node reverseBetween(Node p, int m, int n) {
		
		if(p==null || m>=n) {
			return p;
		}
		
		Node dummy = new Node(-1);
		dummy.next=p;
		Node pre=p;
		for(int i=0; i< m; i++) {
			pre=pre.next;
		}
		
		Node mNode=pre.next;
		Node nNode=mNode.next;
		
	    for(int i=m; i< n; i++) {
	    	Node next = nNode.next;
	    	nNode.next=mNode;
	    	mNode=nNode;
	    	nNode=next;
	    }
	    
	    pre.next.next=nNode;
	    pre.next=mNode;
	    
	    return dummy.next;
		
		
	}

}
