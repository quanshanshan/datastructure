package com.opentext.ecd.dctm.test.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerSocketThread implements Runnable{
	
	Socket socket;
	
	public ServerSocketThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
		System.out.println("server starts to listen at " + socket.getInetAddress());
		InputStream input = socket.getInputStream();
		InputStreamReader reader = new InputStreamReader(input);
		BufferedReader breader = new BufferedReader(reader);
		String client = breader.readLine();
		System.out.println("client sends a request "+ client);
		
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter writer = new OutputStreamWriter(out);
		BufferedWriter bwriter = new BufferedWriter(writer);
		bwriter.write("I have received your request\n");
		bwriter.flush();	
		
	}catch(Exception e) {
		e.printStackTrace();
	}

}
}
