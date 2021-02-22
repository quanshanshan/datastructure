package com.opentext.ecd.dctm.test.designpattern.factory;

import com.opentext.ecd.dctm.test.animal.Animal;
import com.opentext.ecd.dctm.test.animal.Cat;

public class CatFactory implements IanimalFactory {

	@Override
	public Animal getInstance() {
		// TODO Auto-generated method stub
		return new Cat("cat");
	}

}
