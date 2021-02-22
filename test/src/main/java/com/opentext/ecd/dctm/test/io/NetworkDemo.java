package com.opentext.ecd.dctm.test.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkDemo {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(8080);
		Socket socket = server.accept();
		InputStream input = socket.getInputStream();
		
		int size=0;
		
		byte[] bytes = new byte[1024];
		
		while((size=input.read(bytes))!=-1) {
			System.out.println(new String(bytes, 0, size));
		}
		
		
	
		
		
	}

}
