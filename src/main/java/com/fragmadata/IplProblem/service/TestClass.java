package com.fragmadata.IplProblem.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TestClass {

	public static void main(String[] args) {
		
		String format = "|%1$-10s|%2$-10s|%3$-20s|\n";
		 System.out.format(format, "A", "AA", "AAA");
		   System.out.format(format, "B", "", "BBBBB");
		   System.out.format(format, "C", "CCCCC", "CCCCCCCC");
		
		System.out.println();
	}

	static <K, V extends Comparable<? super V>> List<Entry<K, V>> entriesSortedByValues(Map<K, V> map) {

		List<Entry<K, V>> sortedEntries = new ArrayList<Entry<K, V>>(map.entrySet());

		Collections.sort(sortedEntries, new Comparator<Entry<K, V>>() {
			@Override
			public int compare(Entry<K, V> e1, Entry<K, V> e2) {
				return e2.getValue().compareTo(e1.getValue());
			}
		});

		return sortedEntries;
	}
}
