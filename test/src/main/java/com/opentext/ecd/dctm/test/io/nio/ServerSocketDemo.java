package com.opentext.ecd.dctm.test.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketDemo {

	public static void main(String[] args) {
		try {
			ServerSocketChannel serverchannel = ServerSocketChannel.open();
			serverchannel.configureBlocking(false);
			serverchannel.socket().bind(new InetSocketAddress(8080));

			while (true) {
				SocketChannel channel = serverchannel.accept();
				if(channel!=null) {
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				channel.read(buffer);
				System.out.println(new String(buffer.array()));
				buffer.flip();
				
				channel.write(buffer);
				}else {
					Thread.sleep(2000);
					System.out.println("wait for connecting");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
