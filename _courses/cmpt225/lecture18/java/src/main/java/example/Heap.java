package example;

import java.util.*;
import java.lang.Comparable;

public class Heap<T extends Comparable<T>> {

	public List<T> array;

	public Heap() {
		array = new ArrayList<T>();
	}

	/**
	 * builds heap inside the given arraylist
	 * @param array
	 */
	public Heap(List<T> array) {
		this.array = array;

	    // index of last non-leaf node 
	    int last = (array.size()/2) - 1; 
	    // heapify each node 
	    for (int i = last; i >= 0; i--) 
	        heapify(i); 
	}
	
	public String toString() {
		return array.toString();
	}

	public int size() {
		return array.size();
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

	private void heapify(int i) {
		if (i<size()) {
			int j = minVertexOrChildren(i);
			if (j != i) {
				swap(i,j);
				heapify(j);
			}
		}
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

	private int minVertexOrChildren(int i) {
		int min = i;
		if (getLeftChild(i) < size() && array.get(getLeftChild(i)).compareTo(array.get(min)) < 0) {
			min = getLeftChild(i); 
		}
		if (getRightChild(i) < size() && array.get(getRightChild(i)).compareTo(array.get(min)) < 0) {
			min = getRightChild(i); 
		}

		return min;
	}
	
}
