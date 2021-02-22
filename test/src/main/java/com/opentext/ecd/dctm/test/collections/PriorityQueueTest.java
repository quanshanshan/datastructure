package com.opentext.ecd.dctm.test.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		// PriorityQueue<Integer> pq = new PriorityQueue<Integer>(100,
		// Collections.reverseOrder());
		// PriorityQueue<Integer> pq = new PriorityQueue<Integer>( (a,b)-> b-a);

		int[] array = { 2, 3, 5, 8, 11, 22, 97, 98, 33, 44, 55, 66, 77, 88, 99, 100, 12, 13, 14, 15, 16, 17, 18, 19,
				20 };
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(5, (b, a) -> b.compareTo(a));
		pq.addAll(Arrays.asList(2, 3, 5, 8, 11, 22));
		
		for (int a : pq) {
			System.out.println(a);
		}

		for (int a : array) {
			if (a >= pq.peek()) {
				pq.poll();
				pq.add(a);
			}
		}

		for (int a : pq) {
			System.out.println(a);
		}
		
		int[][] points = {{3,3},{5,-1},{-2,4}};
		
		int[][] newarray = kClosest1(points, 2);
		for(int i =0; i< newarray.length; i ++) {
			for(int j=0; j < newarray[i].length; j ++) {
				System.out.println(newarray[i][j]);
			}
		}
		
		  
		}
	
	  public static int[][] kClosest(int[][] points, int K) {		  
		   Comparator<int[]> c = 
		            (int[] a, int[] b) -> 
		                (a[0]*a[0] + a[1]*a[1])  - (b[0]*b[0] + b[1]*b[1]); 
		        Arrays.parallelSort(points, c);
		        return Arrays.copyOfRange(points, 0, K);	        
	    }
	  
	  public static int[][] kClosest1(int[][] points, int K) {
	  PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> -a[0] * a[0] - a[1] * a[1]));	 
      for (int[] p : points) { 
          pq.offer(p); 
          if (pq.size() > K) { pq.poll(); } // poll out the farthest among the K + 1 points.
      }
      int[][] ans = new int[K][2];
      while (K-- > 0) { ans[K] = pq.poll(); }
      return ans;
	  }
	
}
