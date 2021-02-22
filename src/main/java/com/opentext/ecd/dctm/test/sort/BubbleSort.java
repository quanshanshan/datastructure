package com.opentext.ecd.dctm.test.sort;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component("bubble")
public class BubbleSort implements SortInterface {

	@Override
	public void doSort(int[] array) {
		// do comparison of
		
		for(int i=0; i< array.length; i++) {
			for(int j=0; j<array.length -i-1; j++) {
			if(array[j] > array[j+1]) {
				int tmp=array[j];
				array[j]=array[j+1];
				array[j+1] = tmp;				
			}
		}
		}

	}
	
	public static void main(String[] args) {
		SortInterface sort = new BubbleSort();
		Random ran = new Random();
		int[] array = new int[100000];
		int i =0;
		
		while( i < 100000) {
		array[i]= ran.nextInt();
		i++;
		}
	
		long now =System.currentTimeMillis();
		sort.doSort(array);
		System.out.println(System.currentTimeMillis() - now);
//		for(int j: array) {
//			System.out.println(j);
//		}
	}

}
