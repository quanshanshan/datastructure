package com.opentext.ecd.dctm.test.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIODemo {
	
	public static void main(String[] args) {
		try(FileInputStream stream = new FileInputStream("C:/work/copy.txt"); FileOutputStream out= new FileOutputStream("C:/work/copy_11.txt")){
			FileChannel fin = stream.getChannel();
			FileChannel fout = out.getChannel();
			
			fin.transferTo(0,  fin.size(), fout);
			
//			ByteBuffer buffer = ByteBuffer.allocate(1024);
//			fin.read(buffer);
//			buffer.flip();
//			fout.write(buffer);
//			buffer.clear();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
