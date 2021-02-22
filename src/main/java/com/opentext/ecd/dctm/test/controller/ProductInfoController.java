package com.opentext.ecd.dctm.test.controller;

import java.util.Properties;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/info")
public class ProductInfoController {

	@RequestMapping("/")
	String hello() {
		return "Hello World!";
	}

	@RequestMapping(value = "", method=RequestMethod.GET)
	Properties getProperties() {
		Properties property = new Properties();
		for (Object key : System.getProperties().keySet()) {
			property.put(key, System.getProperties().get(key));
		}

		property.putAll(System.getenv());
		return property;

	}

	

}
