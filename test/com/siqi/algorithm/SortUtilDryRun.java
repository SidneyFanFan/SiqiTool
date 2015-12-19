package com.siqi.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.siqi.structure.ComparableEntry;

public class SortUtilDryRun {

	public static void main(String[] args) {
		SortAlgorithm<ComparableEntry<String, Double>, List<ComparableEntry<String, Double>>> su = new SortAlgorithm<ComparableEntry<String, Double>, List<ComparableEntry<String, Double>>>();
		List<ComparableEntry<String, Double>> list = new ArrayList<ComparableEntry<String, Double>>();
		HashMap<String, Double> map = new HashMap<String, Double>();
		map.put("a", (double) 1);
		map.put("b", (double) 0);
		map.put("c", (double) 10);
		map.put("d", (double) 20);
		map.put("e", (double) 3);
		map.put("f", (double) 5);
		map.put("g", (double) 6);
		map.put("h", (double) 4);
		map.put("i", (double) 9);
		map.put("j", (double) 8);
		map.put("k", (double) 12);
		map.put("l", (double) 17);
		map.put("m", (double) 34);
		map.put("n", (double) 11);

		for (Entry<String, Double> en : map.entrySet()) {
			list.add(new ComparableEntry<String, Double>(en.getKey(), en.getValue()));
		}

		su.heapSort(list);
		System.out.println(list);
		su.add2Heap(list, new ComparableEntry<String, Double>("p", (double) 0));
		System.out.println(list);
	}

}
