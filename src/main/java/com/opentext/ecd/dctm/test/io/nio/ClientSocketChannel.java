package com.opentext.ecd.dctm.test.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientSocketChannel {
	
	public static void main(String[] args) {
		try {
			SocketChannel channel = SocketChannel.open();
			
			channel.connect(new InetSocketAddress(8080));
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			buffer.put("new hello".getBytes());
			buffer.flip();
			
			channel.write(buffer);
			buffer.clear();
			channel.read(buffer);
			System.out.println("receive message from server " + new String(buffer.array()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
