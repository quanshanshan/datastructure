package com.opentext.ecd.dctm.test.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Client3 {
	
	static int PORT = 9000;
	
public static void main(String[] args)  {
		
		try{
			
		Socket socket = new Socket("localhost", PORT);	
		System.out.println("clients connects to "+ socket.getLocalPort());
	
		OutputStream outputstream = socket.getOutputStream();
		OutputStreamWriter writer = new OutputStreamWriter(outputstream);
		BufferedWriter bwriter = new BufferedWriter(writer);
		bwriter.write("hello world\n");		
		bwriter.flush();
		
		InputStream input = socket.getInputStream();
		InputStreamReader reader = new InputStreamReader(input);
		BufferedReader breader = new BufferedReader(reader);
		String server = breader.readLine();
		System.out.println("server sends a request "+ server);
		
	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	
		
		
	}

}
