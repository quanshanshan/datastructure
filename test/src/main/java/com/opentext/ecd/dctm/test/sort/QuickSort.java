package com.opentext.ecd.dctm.test.sort;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.springframework.stereotype.Component;

@Component("quick")
public class QuickSort implements SortInterface {

	@Override
	public void doSort(int[] array) {
		quick_sort_c(array, 0, array.length - 1);

	}

	private void quick_sort_c(int[] array, int left, int right) {

		if (left >= right) {
			return;
		}

		int q = partition2(array, left, right); // 获取分区点
		quick_sort_c(array, left, q - 1);
		quick_sort_c(array, q + 1, right);

	}

	private int partition(int[] array, int left, int right) {
		int pivot = array[right];
		int k = left;
		for (int j = left; j < right; j++) {
			if (array[j] < pivot)
				if (k == j) {
					k++;
				} else {

				}
		}

		return k;

	}

	private static int partition2(int[] arr, int left, int right) {
		int pivot = arr[right];
		int i = left;
		for (int j = left; j < right; j++) {
			if (arr[j] < pivot) {
				if (i == j) {
					++i;
				} else {
					swap(arr, i, j);
					i++;
				}
			}
		}
		swap(arr, i, right);
		return i;
	}

	static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;

	}

	public static void main(String[] args) throws IOException {
		SortInterface sort = new QuickSort();
		Random ran = new Random();
		int[] array = new int[100000];
		int i = 0;

		while (i < 100000) {
			array[i] = ran.nextInt();
			i++;
		}

		long now = System.currentTimeMillis();
		sort.doSort(array);
		System.out.println(System.currentTimeMillis() - now);
		
		System.out.println(QuickSort.class.getCanonicalName());
		
		JarFile jarFile = new JarFile(new File("C:\\work\\gitbang\\GCViewer-develop\\target\\gcviewer-1.37-SNAPSHOT.jar"));
		Enumeration<JarEntry> set = jarFile.entries();
		Set<String> classes = new HashSet<String>();
		while(set.hasMoreElements()) {
			JarEntry entry = set.nextElement();		
			if(entry.getName().endsWith(".class")) {
				String name = entry.getName().replace("/", ".").replace(".class", "");
			classes.add(name);
			}
		}
		
		for(String name: classes) {
			System.out.println(name);
		}
		
	}

}
