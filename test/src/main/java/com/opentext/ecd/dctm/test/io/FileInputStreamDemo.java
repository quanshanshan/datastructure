package com.opentext.ecd.dctm.test.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamDemo {
	
	

	public static void main(String[] args) throws IOException {
		// byte read

		try (FileInputStream inputstream = new FileInputStream(new File("C:/work/copy.txt"));
				FileOutputStream outputstream = new FileOutputStream(new File("C:/work/test_cp.txt"));) {

			int size;
			int count =0;

			//byte[] buffer = new byte[1024];
			while ((size = inputstream.read()) != -1) {
				count++;
				System.out.print((char)size);
				
				//outputstream.write(size);
			}
			System.out.println(count);
		} catch (IOException e) {
			throw e;
		}

	}

}
