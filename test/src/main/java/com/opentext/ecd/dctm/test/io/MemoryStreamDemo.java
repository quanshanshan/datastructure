package com.opentext.ecd.dctm.test.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class MemoryStreamDemo {
	
	static String hello = "Hello World";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// no need to close the stream
		
		ByteArrayInputStream inpustream = new ByteArrayInputStream(hello.getBytes());
		ByteArrayOutputStream outstream = new ByteArrayOutputStream();
		
		int i =0;
		while((i=inpustream.read())!=-1) {
			char c = (char)i;
			outstream.write(Character.toUpperCase(c));
		}
		
		System.out.println(outstream.toString());
		
		
		
	}

}
