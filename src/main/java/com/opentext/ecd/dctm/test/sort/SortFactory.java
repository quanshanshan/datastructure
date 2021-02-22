package com.opentext.ecd.dctm.test.sort;

import java.util.HashMap;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;



public class SortFactory {
	
	private static HashMap<String, SortInterface> sorts = new HashMap<String, SortInterface>();
	
	public static SortInterface getInstance(String name) {
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		for(Object name1: context.getBeanNamesForType(SortInterface.class)) {
			System.out.println(name1);
		}
		return null;
		
		
		
//    switch(name) {
//		
//		case "quick":
//			return new QuickSort().doSort(array);
//			
//		case "bubble":
//			doBubbleSort(array);
//			break;
//		case "insert":
//			doInsertSort(array);
//			break;
//		case "binary":
//			doBinarySort(array);
//			break;
//		case "merge":
//			doMergeSort(array);
//			break;
//			
//		}
		
	}
	
	

}
