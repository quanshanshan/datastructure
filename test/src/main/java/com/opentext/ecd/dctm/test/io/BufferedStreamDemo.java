package com.opentext.ecd.dctm.test.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.util.StopWatch;

public class BufferedStreamDemo {

	static File source = new File("C:/work/2020KT/Grenoble KT- DFC Search Service.arf");
	static File target = new File("C:/work/Grenoble KT- DFC Search Service_cp.arf");

	static void copyWithBuffer() {
		try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(source));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(target));) {

			byte[] bytes = new byte[1024];
			int i;
			while ((i = input.read(bytes)) != -1) {
				out.write(bytes, 0, i);
				//out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static void copyWithNormal() {
		try (FileInputStream input = new FileInputStream(source);
				FileOutputStream out = new FileOutputStream(target);) {

			byte[] bytes = new byte[1024];
			int i;
			while ((i = input.read(bytes)) != -1) {
				out.write(bytes);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		StopWatch watch = new StopWatch();
		watch.start();
		//copyWithNormal();
		watch.stop();
		System.out.println("copy with normal " + watch.getLastTaskTimeMillis());

		watch.start();
		copyWithBuffer();
		watch.stop();
		System.out.println("copy with buffer " + watch.getLastTaskTimeMillis());

	}

}
