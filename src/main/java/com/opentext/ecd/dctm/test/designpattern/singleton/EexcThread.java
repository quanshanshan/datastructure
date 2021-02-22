package com.opentext.ecd.dctm.test.designpattern.singleton;

public class EexcThread extends Thread{

	@Override
	public void run() {
		//HungrySingleton instance = HungrySingleton.getInstance();
	//	LazySingleton instance = LazySingleton.getInstance();
		//Lazy2 instance = Lazy2.getInstance();
		//Lazy3 instance = Lazy3.getInstance();
		EnumSingleton instance = EnumSingleton.INSTANCE;
	//	InnerClass instance = InnerClass.getInstance();
		System.out.println(instance);
		
	}

}
