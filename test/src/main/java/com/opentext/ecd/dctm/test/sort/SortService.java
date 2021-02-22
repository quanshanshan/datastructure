package com.opentext.ecd.dctm.test.sort;

public class SortService {
	
	static void dosort(String mode, int[] array){
		SortFactory.getInstance(mode).doSort(array);
		
		
		
	}

	private void doInsertSort(int[] array) {
		SortFactory.getInstance("insert");
		
	}

	private void doBinarySort(int[] array) {
		SortFactory.getInstance("binary");
		
	}

	private void doMergeSort(int[] array) {
		SortFactory.getInstance("merge");
		
	}

	private void doBubbleSort(int[] array) {
		SortFactory.getInstance("bubble");	
		
	}

	private void doquicksort(int[] array) {
		// TODO Auto-generated method stub
		
	}
	

}
