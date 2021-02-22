package com.opentext.ecd.dctm.test.thread;

import java.io.IOException;

import org.openjdk.jol.info.ClassLayout;

public class SynchronizationDemo {

	static Integer count = 0;
	static Object object = new Object();

	public static void incr() {

		synchronized (object) {

			try {

				Thread.sleep(1);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

			count++;
			
			Task newobject = new Task();
			
			System.out.println(newobject.hashCode());
			
			//System.out.println(ClassLayout.parseInstance(object).toPrintable());
			System.out.println(ClassLayout.parseInstance(newobject).toPrintable());

		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		for (int i = 0; i < 2; i++) {

			new Thread(() -> SynchronizationDemo.incr()).start();

		}

		Thread.sleep(5000);

		System.out.println("result:" + count);

	}

}
