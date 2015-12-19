package com.siqi.algorithm;

import java.util.List;

public class SortAlgorithm<E extends Comparable<E>, T extends List<E>> {

	/**
	 * must specify a input type and return type and data type
	 */
	public SortAlgorithm() {

	}

	public void heapSort(T sort) {
		buildMaxHeapify(sort);
		recurHeapSort(sort);
	}

	private void buildMaxHeapify(T sort) {
		int startIndex = getParentIndex(sort.size() - 1);
		for (int i = startIndex; i >= 0; i--) {
			maxHeapify(sort, sort.size(), i);
		}
	}

	private void maxHeapify(T data, int heapSize, int index) {
		int left = getChildLeftIndex(index);
		int right = getChildRightIndex(index);
		int largest = index;
		if (left < heapSize && data.get(index).compareTo(data.get(left)) > 0) {
			largest = left;
		}
		if (right < heapSize && data.get(largest).compareTo(data.get(right)) > 0) {
			largest = right;
		}
		if (largest != index) {
			swap(data, index, largest);
			maxHeapify(data, heapSize, largest);
		}
	}

	public void add2Heap(T heap, E e) {
		int pos = 0;
		for (pos = 0; pos < heap.size(); pos++) {
			if (e.compareTo(heap.get(pos)) >= 0) {
				break;
			}
		}
		heap.add(pos, e);
	}

	private void recurHeapSort(T sort) {
		for (int i = sort.size() - 1; i > 0; i--) {
			swap(sort, 0, i);
			maxHeapify(sort, i, 0);
		}
	}

	private void swap(T data, int index1, int index2) {
		E temp = data.get(index1);
		data.set(index1, data.get(index2));
		data.set(index2, temp);
	}

	private static int getParentIndex(int current) {
		return (current - 1) >> 1;
	}

	private static int getChildLeftIndex(int current) {
		return (current << 1) + 1;
	}

	private static int getChildRightIndex(int current) {
		return (current << 1) + 2;
	}

	public void print(T data) {
		int pre = -2;
		for (int i = 0; i < data.size(); i++) {
			if (pre < (int) (Math.log(i + 1) / Math.log(2))) {
				pre = (int) (Math.log(i + 1) / Math.log(2));
				System.out.println();
			}
			System.out.print(data.get(i) + " |");
		}
		System.out.println();
	}

}
