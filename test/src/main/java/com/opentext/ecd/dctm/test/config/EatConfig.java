package com.opentext.ecd.dctm.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.opentext.ecd.dctm.test.animal.Dog;
import com.opentext.ecd.dctm.test.animal.EatService;
import com.opentext.ecd.dctm.test.animal.SingleTon;

@Configuration
public class EatConfig {

	@Value("${eat.number:5}")
	int number;

	@Value("${eat.name:eat}")
	String name = "eat";

	@Value("${dogname:pony}")
	String dogName;

	@Bean
	Dog getDog() {
		return new Dog(dogName);
	}

	@Bean
	EatService getService() {
		return new EatService(number, name);
	}
	
	@Bean
	SingleTon getSingle() {
		return SingleTon.getInstance();
	}

}
