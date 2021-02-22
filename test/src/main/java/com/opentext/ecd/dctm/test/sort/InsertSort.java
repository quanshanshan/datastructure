package com.opentext.ecd.dctm.test.sort;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component("insert")
public class InsertSort implements SortInterface {

	@Override
	public void doSort(int[] array) {
		for(int i =0 ; i< array.length; i++) {
			int value = array[i];
			int j = i-1;
			for(;j>0; j--) {
				if(array[j]>value) {
					array[j+1] = array[j];
				}else {
					break;
				}
			}
			
			array[j+1] = value;
		}

	}

	public static void main(String[] args) {
		SortInterface sort = new InsertSort();
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
