package com.opentext.ecd.dctm.test.designpattern.factory;

import java.util.ArrayList;
import java.util.List;

public class BeanDefinition {
	private String id;
	private String className;
	private List<ConstructorArg> constructorArgs = new ArrayList<>();
	private Scope scope = Scope.SINGLETON;
	private boolean lazyInit = false; // 省略必要的getter/setter/constructors

	public boolean isSingleton() {
		return scope.equals(Scope.SINGLETON);
	}

	public static enum Scope {
		SINGLETON, PROTOTYPE
	}

	public static class ConstructorArg {
		private boolean isRef;
		private Class type;
		private Object arg; // 省略必要的getter/setter/constructors }}
	}

}
