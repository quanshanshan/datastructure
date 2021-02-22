package com.opentext.ecd.dctm.test.animal;

public class SingleTon {
	
	private static SingleTon single;
	private static int i;
	private static String ABC;
	
	static {
		i=0;
		ABC= "abc";
	}
	
	private SingleTon() {
		
	}
	
	public static SingleTon getInstance() {
		if(single==null) {
			single = new SingleTon();
		}
		
		return single;
	}
	
	public void test() {
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		//int i = 0;
//		System.out.println(i);
//		System.out.println(ABC);
		SingleTon s = SingleTon.getInstance(); 
		
//		System.out.println(SingleTon.class.getClassLoader());
//		System.out.println(SingleTon.class.getClassLoader().getParent());
//		System.out.println(SingleTon.class.getClassLoader().getParent().getParent());
//		
//		System.out.println(new String().getClass().getClassLoader());
//		
//		System.out.println(new Dog("abc").getClass().getClassLoader());
//		
//		Class.forName("com.opentext.ecd.dctm.test.animal.Dog");
		System.out.println(System.getProperty("java.system.class.loader"));
		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println(System.getProperty("java.class.path"));
		
		ClassLoader.getSystemClassLoader().loadClass("com.opentext.ecd.dctm.test.animal.Dog");
	}

}
