package com.opentext.ecd.dctm.test.collections;

import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

import com.opentext.ecd.dctm.test.animal.Size;

public class HashMapTest {

	public static void main(String[] args) {

		HashMap<Integer, String> languages = new HashMap<Integer, String>();

		languages.put(1, "Java");
		languages.put(2, "Python");
		languages.put(3, "C++");

		for (Integer i : languages.keySet()) {
			System.out.println(i);
		}

		for (String value : languages.values()) {
			System.out.println(value);
		}

		for (Entry<Integer, String> entry : languages.entrySet()) {
			System.out.println(String.format("languages %d, %s", entry.getKey(), entry.getValue()));
		}

		languages.replace(2, "Scala");
		System.out.println(languages);
		languages.replace(1, "Python", "Java");
		System.out.println(languages);
		languages.replace(1, "Java", "Python");
		System.out.println(languages);

		languages.replaceAll((key, value) -> value.toUpperCase());
		System.out.println(languages);

//		languages.replaceAll((key, value)-> String.valueOf(key * key));
//		System.out.println(languages);

		LinkedHashMap<Integer, String> lmap = new LinkedHashMap<Integer, String>(languages);
		lmap.forEach((key, value) -> System.out.println(value));
		System.out.println(lmap);

		String two = new String("Two");

		lmap.put(4, two);

		two = null;
		System.gc();
		lmap.forEach((key, value) -> System.out.println("After GC for LinkedHashMap " + value));

		WeakHashMap<String, Integer> wmap = new WeakHashMap<String, Integer>();

		String two1 = new String("Two1");
		wmap.put(two1, 2);
		String one = new String("one");
		wmap.put(one, 1);

		wmap.forEach((key, value) -> System.out.println("Before GC for WeakHashMap " + key + " value " + value));

		two1 = null;
		System.gc();
		wmap.forEach((key, value) -> System.out.println("after GC for WeakHashMap " + key + " value " + value));

		System.out.println(wmap.getOrDefault("three", 3));

		EnumMap<Size, Integer> emap = new EnumMap<Size, Integer>(Size.class);
		emap.put(Size.EXTRALARGE, 1);
		emap.put(Size.LARGE, 2);
		System.out.println("emap " + emap.keySet());

		SortedMap<Integer, String> smap = new TreeMap<Integer, String>();		
		NavigableMap<Integer, String> nmap = new TreeMap<Integer, String>((a, b) -> b - a);
		nmap.put(3, "abc");
		nmap.put(2, "def");
		nmap.put(1, "abc");
		System.out.println("nmap " + nmap.firstKey());		
		System.out.println(nmap.headMap(2));
		
		ConcurrentHashMap<String, Integer> cmap = new ConcurrentHashMap<String, Integer>();
		cmap.put("five", 5);
		Enumeration<Integer> enu = cmap.elements();
		while (enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}

		ConcurrentSkipListMap<Integer, String> skipMap = new ConcurrentSkipListMap<Integer, String>((a, b) -> a - b);
		skipMap.put(1, "c");
		skipMap.put(3, "a");
		skipMap.put(2, "b");
		skipMap.put(4, "d");
		System.out.println(skipMap.comparator());
		System.out.println(skipMap.ceilingKey(2));

		System.out.println(skipMap);

	}

}
