package com.opentext.ecd.dctm.test.designpattern.singleton;

public class ConfigSingleton {
	
	private static ConfigSingleton instance = null;
	private final int param_A;
	private final int param_B;
	
	private ConfigSingleton() {
		this.param_A = Config.PARAM_A;
		this.param_B = Config.PARAM_B;
		
	}
	
	public ConfigSingleton getInstance() {
		if(instance == null) {
			instance = new ConfigSingleton();
		}
		return instance;
		
	}
	

}

