package com.opentext.ecd.dctm.test.string;

public class StringTest {

	public static void main(String[] args) {
		String s = "abcdefghhhhhhhhhabababbabab";
		String toFind = "abab";
		System.out.println(StringTest.bF(s, toFind));
		System.out.println(StringTest.rK(s, toFind));
	}

	static int bF(String primary, String toFind) {
		int m = primary.length();
		int n = toFind.length();
		int k;
		char[] array = primary.toCharArray();
		char[] array1 = toFind.toCharArray();
		for (int i = 0; i < m - n; i++) {
			k = 0;
			for (int j = 0; j < n; j++) {

				if (array[i + j] == array1[j]) {
					k++;
				} else {
					break;
				}

				if (k == n) {
					return i;
				}

			}
		}
		return -1;

	}

	static int rK(String primary, String toFind) {
		int m = primary.length();
		int n = toFind.length();
		char[] array = primary.toCharArray();
		char[] array1 = toFind.toCharArray();
		int s = 1;
		int[] hash = new int[m - n + 1];
		int[] table = new int[26];
		for (int j = 0; j < 26; j++) {
			table[j] = s;
			s *= 26;
		}

		for (int i = 0; i <= m - n; i++) {
			s = 0;
			for (int j = 0; j < n; j++) {
				s += (array[i + j] - 'a') * table[n - 1 - j];
			}
			hash[i] = s;
		}
		s = 0;
		for (int j = 0; j < n; j++) {
			s += (array1[j] - 'a') * table[n - 1 - j];
		}
		for (int j = 0; j < m - n + 1; j++) {
			if (hash[j] == s) {
				return j;
			}
		}
		return -1;

	}

}