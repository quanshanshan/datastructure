package com.opentext.ecd.dctm.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opentext.ecd.dctm.test.animal.Dog;
import com.opentext.ecd.dctm.test.animal.EatService;
import com.opentext.ecd.dctm.test.animal.SingleTon;

@RestController
public class DogController {

	@Autowired
	EatService eat;

	@Autowired
	Dog dog;

	@RequestMapping("/single")
	String getSingleton() {
		return SingleTon.getInstance().toString();
	}

	@RequestMapping("/eat")
	int eat() {
		return eat.getNumber();
	}

	@RequestMapping("/display")
	void display() {
		eat.display();
	}
	
	@RequestMapping("/animal")
	String getAnimal() {
		return dog.toString();
	}

}
