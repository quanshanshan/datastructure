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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	
	static int PORT= 9000;
	public static void main(String[] args) {

		try{
			
		ServerSocket server = new ServerSocket(PORT);	
		System.out.println("server starts to listen at " + server.getLocalPort());
		ExecutorService service = Executors.newFixedThreadPool(4);

		
		while(true) {
		Socket socket = server.accept();
		service.submit(new ServerSocketThread(socket));
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
