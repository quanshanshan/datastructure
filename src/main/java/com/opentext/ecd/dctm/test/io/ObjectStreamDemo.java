package com.opentext.ecd.dctm.test.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.opentext.ecd.dctm.test.thread.blockingqueue.User;

public class ObjectStreamDemo {
	
	public static void main(String[] args) {
		try(
		ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("c:/work/user.txt"));ObjectInputStream input = new ObjectInputStream(new FileInputStream("c:/work/user.txt"));){
			stream.writeObject(new User("test"));			
			User user = (User)input.readObject();			
			System.out.println(user);
		}catch(IOException  | ClassNotFoundException e) {
			e.printStackTrace();
		
	}
	}

}
