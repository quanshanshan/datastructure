package com.opentext.ecd.dctm.test.sort;

public class BucketSort implements SortInterface {

	@Override
	public void doSort(int[] array) {
		this.doSort(array, 10);

	}

	public void doSort(int[] array, int bucketSize) {

		if (array.length < 2) {
			return;
		}

		int min = array[0];
		int max = array[1];

		for (int i = 0; i < array.length; i++) {
			if (min > array[i]) {
				min = array[i];
			} else if (max < array[i]) {
				max = array[i];
			}
		}
		
		int bucketCount = (max- min)/bucketSize + 1;
		
		int[][] bucket = new int[bucketCount][bucketSize];
		int[] indexattr = new int[bucketCount];
		
		for(int i =0; i< array.length; i++) {
			int bucketindex =  (array[i]-min)/bucketSize;
			if(indexattr[bucketindex] == bucket[bucketindex].length) {
				ensureCap(bucket, bucketindex);
			}
			
			bucket[bucketindex][indexattr[bucketindex]++] = array[i];
		}
		
		
		
		

	}

	private void ensureCap(int[][] bucket, int bucketindex) {
		 int[] tempArr = bucket[bucketindex];
	        int[] newArr = new int[tempArr.length * 2];
	        for (int j = 0; j < tempArr.length; j++) {
	            newArr[j] = tempArr[j];
	        }
	        bucket[bucketindex] = newArr;
		
	}
	
	public static void main(String[] args) {
		
	}

}
