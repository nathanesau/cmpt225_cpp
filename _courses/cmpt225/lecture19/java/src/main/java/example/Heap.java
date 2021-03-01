package example;

import java.util.*;
import java.lang.Comparable;

public class Heap<T extends Comparable<T>> {

	public ArrayList<T> array;

	public Heap() {
		array = new ArrayList<T>();
	}

	/**
	 * Creates Heap on the list as
	 * @param list
	 */
	public Heap(ArrayList<T> list) {
		array = list;
		buildHeap();
	}

	public boolean isEmpty() {
		return array.isEmpty();
	}

	public T getMin() {
		return array.get(0);
	}

	public void add(T item) {
		array.add(item); // append to the end of the list

		// propagate up
		int i = array.size() - 1;
		while (i>0 && array.get(i).compareTo(array.get(getParent(i))) < 0) {
			// swap array[i] and array[parent of i]
			swap(i, getParent(i));
		}
	}

	public T removeMin() {
		T ret = array.get(0);

		// TODO implement me
		array.set(0, array.get(array.size()-1));
		array.remove(array.size()-1);

		if (size()>0) 
			heapify(0);

		return ret;
	}

	/**
	 * Implementation of the heapSort algorithm
	 * @param <E>
	 * @param list
	 */
	public static <E extends Comparable<E>> void heapSort(ArrayList<E> list) {
		Heap<E> heap = new Heap<E>(list);
		heap.heapSort();
	}


	public String toString() {
		return array.toString();
	}

	public int size() {
		return array.size();
	}
	private int getLeftChild(int i) {
		return 2*i+1;
	}

	private int getRightChild(int i) {
		return 2*i+2;
	}

	private int getParent(int i) {
		return ((i+1)/2)-1;
	}

	private void swap(int i, int j) {
		T tmp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, tmp);
	}

	public void heapify(int i) {
		if (i<array.size()) {
			int j = minVertexOrChildren(i);
			if (j != i) {
				swap(i,j);
				heapify(j);
			}
		}
	}

	public int minVertexOrChildren(int i) {
		int min = i;
		if (getLeftChild(i) < array.size() && array.get(getLeftChild(i)).compareTo(array.get(min)) < 0) {
			min = getLeftChild(i); 
		}
		if (getRightChild(i) < array.size() && array.get(getRightChild(i)).compareTo(array.get(min)) < 0) {
			min = getRightChild(i); 
		}

		return min;
	}

	/**
	 * builds heap inside the given arraylist
	 * @param array
	 */
	public void buildHeap() {
		// heapify each node 
		for (int i = size()-1; i >= 0; i--)  
			heapify(i); 
	}

	/**
	 * implementation of heapSort
	 * @param array
	 */
	public void heapSort() {
		buildHeap(); 
		int size = array.size();
		ArrayList<T> sorted = new ArrayList<T>(size);
		for (int i = 0; i < size; i++)
			sorted.add(removeMin());
		array.addAll(sorted);

	}
	
}
