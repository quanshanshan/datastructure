package com.opentext.ecd.dctm.test.designpattern.builder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	
	public User(String userName, int userAge) {
		this.name = userName;
		this.age = userAge;		
	}
	String name;
	int age;

}
