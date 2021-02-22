package com.opentext.ecd.dctm.test;


import java.util.ArrayList;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opentext.ecd.dctm.test.thread.blockingqueue.User;



@SpringBootApplication
public class App {
    public static void main(String[] args) throws InterruptedException  {
        SpringApplication.run(App.class, args);
  
        
        
        while(true) {
        	
        	String username = String.valueOf(new Random().nextInt());
        	User user = new User(username);
        	Thread.sleep(1000);
        	
        	ArrayList<Integer> list = new ArrayList<Integer>(100000000);
        }
           
      
    
}}