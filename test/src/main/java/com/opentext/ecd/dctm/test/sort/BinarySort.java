package com.opentext.ecd.dctm.test.sort;

import org.springframework.stereotype.Component;

@Component("binary")
public class BinarySort implements SortInterface {

	@Override
	public void doSort(int[] array) {

	}

	// no repeatable numbers
	public static int binarySearch(int[] array, int n, int value) {
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (array[mid] == value) {
				return mid;
			}
			if (array[mid] < value) {
				low = mid + 1;
			}

			if (array[mid] > value) {
				high = mid - 1;
			}
		}
		return -1;
	}

	// find the first occurrence of certain number
	public static int binarySearch1(int[] array, int n, int value) {

		int low = 0;
		int high = n - 1;

		while (low <= high) {
			// int mid = (low + high)/2;
			int mid = low + ((high - low) >> 1);

			if (array[mid] < value) {
				low = mid + 1;
			} else

			if (array[mid] > value) {
				high = mid - 1;
			} else

			if (array[mid] == value) {
				if (mid == 0 || array[mid - 1] != value)
					return mid;
				else {
					high = mid - 1;
				}
			}
		}

		return -1;

	}

	// find the last occurrence of certain number
	public static int binarySearch2(int[] array, int n, int value) {
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (array[mid] < value) {
				low = mid + 1;
			} else if (array[mid] > value) {
				high = mid - 1;
			} else if (array[mid] == value) {
				if (mid == n - 1 || array[mid + 1] != value) {
					return mid;
				} else {
					low = mid + 1;
				}
			}
		}

		return -1;

	}
	
	// find the first occurrence greater or equals with one value
	public static int binarySearch3(int[] array, int n, int value) {
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (array[mid] <= value) {
				if (mid == n - 1 || array[mid + 1] != value) {
					return mid + 1;
				} else {
					low = mid + 1;
				}
			} else if (array[mid] > value) {
				high = mid - 1;
			}
		}

		return -1;
		
		
		
	}
	
	//find the last occurrence less or equals with one value
	public static int binarySearch4(int[] array, int n, int value) {
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (array[mid] < value) {
				low = mid + 1;
			} else if (array[mid] >= value) {	
		 
				if (mid == 0 || array[mid - 1] != value) {
					return mid -1;
				} else {
					high = mid - 1;
				
			}
		}
		}

		return -1;
	}
	
	public static long ipToLong(String strIp) {
		
		
		
		  String[]ip = strIp.split("\\.");  
	        return (Long.parseLong(ip[0]) << 24) + (Long.parseLong(ip[1]) << 16) + (Long.parseLong(ip[2]) << 8) + Long.parseLong(ip[3]);  
		
			
	}
	
	
	 public static String longToIP(long longIp) {  
	        StringBuffer sb = new StringBuffer("");  
	        // ������������24���  
	        sb.append(String.valueOf((longIp >>> 24)));  
	        sb.append(".");  
	        // ������8������0���������������16���  
	        sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));  
	        sb.append(".");  
	        // ������16������0���������������8���  
	        sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));  
	        sb.append(".");  
	        // ������24������0  
	        sb.append(String.valueOf((longIp & 0x000000FF)));  
	        return sb.toString();  
	    }  

	public static void main(String[] args) {

		int[] array = { 1, 3, 5, 7, 9, 11, 15 };
		
		System.out.println(BinarySort.binarySearch(array, 7, 3));

		int[] array1 = { 1, 2, 3, 3, 3, 4, 5 };
		System.out.println(BinarySort.binarySearch1(array1, 7, 3));

		System.out.println(BinarySort.binarySearch2(array1, 7, 3));
		
		System.out.println(BinarySort.binarySearch3(array1, 7, 3));
		
		System.out.println(BinarySort.binarySearch4(array1, 7, 3));
		
		System.out.println(ipToLong("10.245.38.60"));
		System.out.println(longToIP(183838268));

	}

}
