package com.opentext.ecd.dctm.test.designpattern.builder;

import org.springframework.util.StringUtils;

public class UserBuilder {
	
	String userName;
	int userAge;
	
	
	public User build() {
		return new User(userName, userAge);
		
	}
	
	public UserBuilder setName(String name) {
		if(name == null ||StringUtils.isEmpty(name)) {
			this.userName = "default";
		}else {
			this.userName = name;
		}
		return this;
	}
	
	public UserBuilder setAge(int age) {
		if(age <1) {
			this.userAge = 1;
		}else {
			this.userAge = age;
		}
		return this;
	}

}
