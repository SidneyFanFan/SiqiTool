package com.siqi.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataUtil {

	public static void printMatirx(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.printf("%s ", matrix[i][j]);
			if (i != matrix.length)
				System.out.println();
		}
	}

	public static int[][] initMatirx(int m, int n, int value) {
		int[][] matrix = new int[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				matrix[i][j] = value;
		return matrix;
	}

	public static int arraySum(int[] entity) {
		int sum = 0;
		for (int i : entity) {
			sum += i;
		}
		return sum;
	}

	public static List<Set<Integer>> arrayListWithout(List<Set<Integer>> conditionSetList, int j) {
		List<Set<Integer>> removedList = new ArrayList<Set<Integer>>();
		for (int i = 0; i < conditionSetList.size(); i++) {
			if (i != j) {
				removedList.add(conditionSetList.get(i));
			}
		}
		return removedList;
	}

	public static Set<Integer> intersectSets(List<Set<Integer>> setList) {
		Set<Integer> intersection = new HashSet<Integer>();
		Set<Integer> first = setList.get(0);
		for (Integer integer : first) {
			boolean allContains = true;
			for (int i = 0; i < setList.size(); i++) {
				if (!setList.get(i).contains(integer)) {
					allContains = false;
					break;
				}
			}
			if (allContains) {
				intersection.add(integer);
			}
		}
		return intersection;
	}

	public static List<Set<Integer>> arrayListWithCombination(ArrayList<HashSet<Integer>> conditionSetList,
			int[] combination) {
		List<Set<Integer>> removedList = new ArrayList<Set<Integer>>();
		for (int i = 0; i < combination.length; i++) {
			if (combination[i] == 1) {
				removedList.add(conditionSetList.get(i));
			}
		}
		return removedList;
	}

	public static boolean subArray(int[] localCombination, int[] combination) {
		int[] joint = intersectArray(localCombination, combination);
		boolean compare = compareArray(localCombination, joint);
		return compare;
	}

	public static boolean compareArray(int[] a1, int[] a2) {
		for (int i = 0; i < a1.length; i++) {
			if (a1[i] != a2[i]) {
				return false;
			}
		}
		return true;
	}

	public static int[] intersectArray(int[] a1, int[] a2) {
		int[] joint = new int[a1.length];
		for (int i = 0; i < joint.length; i++) {
			if (a1[i] == 1 && a1[i] == a2[i]) {
				joint[i] = 1;
			} else {
				joint[i] = 0;
			}
		}
		return joint;
	}

	public static String printArray(String[] array) {
		String str = "";
		ArrayList<String> politicsList = new ArrayList<String>();
		for (String string : array) {
			string = string.trim();
			if (!string.isEmpty()) {
				politicsList.add(string.replace('\'', '_').replace('.', '_').replace('"', '_').replace(' ', '_')
						.replace('-', '_'));
			}
		}
		str = politicsList.toString();
		return str;
	}

	public static List<String> parseArrayString(String string) {
		ArrayList<String> list = new ArrayList<String>();
		int leftParr = string.indexOf('[');
		int rightParr = string.lastIndexOf(']');
		String inner = string.substring(leftParr + 1, rightParr);
		String[] eles = inner.split(",");
		for (String ele : eles) {
			list.add(ele.trim());
		}
		return list;
	}
}
