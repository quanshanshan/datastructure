package com.opentext.ecd.dctm.test.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertDemo {
	
	public static void main(String[] args) {
		
		try(BufferedInputStream binput = new BufferedInputStream(new FileInputStream("C:/work/copy.txt")); InputStreamReader reader = new InputStreamReader(binput,"UTF-8");){
			
			BufferedReader breader = new BufferedReader(reader);
			
			String s;
			while((s=breader.readLine())!=null) {
			System.out.println(s);
			}
		}catch(IOException e) {
			
		}
		
	}

}
