package com.opentext.ecd.dctm.test.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
	
	public static void main(String[] args) {
		try(FileReader reader = new FileReader(new File("C:/work/copy.txt"))){
			
			int size=0;
			int count=0;
			while((size=reader.read())!=-1) {
				count++;
				System.out.print((char)size);
			}
			
			System.out.println(count);
		}
		catch(IOException e) {
			
		}
	}

}
