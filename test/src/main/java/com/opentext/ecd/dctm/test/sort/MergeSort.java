package com.opentext.ecd.dctm.test.sort;

import java.util.Random;

public class MergeSort implements SortInterface {

	@Override
	public void doSort(int[] array) {
		
		doMergeSort(array, array.length);

	}
	
	private void doMergeSort(int[] array, int length) {
		merge_sort_c(array, 0, length-1);
		
	}

	private void merge_sort_c(int[] array, int i, int j) {
		if(i>=j) return;
		
		int p = (i+j)/2;		
		merge_sort_c(array, i, p);
		merge_sort_c(array, p+1, j);
		merge(array, i, p, j);
		
	}

	 private static void merge(int[] arr, int left, int q, int right) {
	        int i = left;
	        int j = q + 1;
	        int k = 0;
	        int[] tmp = new int[right - left + 1];
	        while (i <= q && j <= right) {
	            if (arr[i] <= arr[j]) {
	                tmp[k++] = arr[i++];
	            } else {
	                tmp[k++] = arr[j++];
	            }
	        }
	        int start = i;
	        int end = q;
	        if (j <= right) {
	            start = j;
	            end = right;
	        }
	        while (start <= end) {
	            tmp[k++] = arr[start++];
	        }
	        for (int l = 0; l <= right - left; l++) {
	            arr[l + left] = tmp[l];
	        }

	    }

	
	 public static void main(String[] args) {
			SortInterface sort = new MergeSort();
			Random ran = new Random();
			int[] array = new int[10000];
			int i =0;
			
			while( i < 10000) {
			array[i]= ran.nextInt();
			i++;
			}
		
			long now =System.currentTimeMillis();
			sort.doSort(array);
			System.out.println(System.currentTimeMillis() - now);
//			for(int j: array) {
//				System.out.println(j);
//			}
		}

}
