package example;

import java.util.ArrayList;

public class SearchSorted {

	/**
	 * search for an element in the given array of integers Prerequisite: the array
	 * is sorted in the increasing order
	 * 
	 * @param a       - an array
	 * 
	 * @param element - an integer
	 * 
	 * @return the index in the array that contains the given element s * if element
	 *         is not in the array, returns -1
	 */
	public static <E extends Comparable<E>> int findElement(ArrayList<E> a, E element) {
		int left = 0;
		int right = a.size() - 1;
		int mid = (left + right) / 2;

		while (!(a.get(mid)).equals(element) && left < right) {
			if ((a.get(mid)).compareTo(element) > 0)
				right = mid - 1;
			else // a[mid] < element
				left = mid + 1;

			mid = (left + right) / 2;
		}

		if ((a.get(mid)).equals(element))
			return mid;
		else
			return -1;
	}

}
