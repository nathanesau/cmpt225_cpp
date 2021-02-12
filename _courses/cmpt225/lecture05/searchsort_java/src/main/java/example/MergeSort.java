package example;

import java.util.ArrayList;

public class MergeSort {

	/**
	 * the method gets as parameters an ArrayList of Generic s<E>
	 * and two indices - start < end.
	 * It sorts the array in the section [start,end] in an increasing order   
	 * @param a
	 * 		an array of E
	 * @param start
	 * 		an index in the array
	 * @param end
	 * 		an index in the array
	 *   @return void
	 */
	private static  <E extends Comparable<E>> void mergeSort(ArrayList<E> a, int start, int end) {
		if (end > start) 
		{
			int mid = (start + end)/2;
			mergeSort(a, start, mid);
			mergeSort(a, mid+1, end);
			merge(a, start, mid, end);
		}
		
	}
	
	/**
	 * the method gets as parameters an array of ints
	 * and 3 indices - start <= mid <= end.
	 * Requirements: a[start...mid] and a[mid+1...end] are sorted in an increasing order
	 * 
	 * It merges the two halves into a sorted array in an increasing order
	 * The implementation is more efficient, though it uses an additional array, 
	 *    
	 * @param a
	 * 		an array of integers
	 * @param start
	 * 		an index in the array
	 * @param mid
	 * 		an index in the array
	 * @param end
	 * 		an index in the array
	 *   @return void
	 */
	private static <E extends Comparable<E>> void merge(ArrayList<E> a, int start, int mid, int end)
	{
		ArrayList<E> tmp = new ArrayList<E>(end-start+1);

		// merging a[start...mid] and a[mid+1...end] into tmp
		int step1 = start;
		int step2 = mid+1;
		while (step1<=mid || step2<=end)
		{
			if (step1 > mid)
				tmp.add(a.get(step2++));
			else if (step2 > end)
				tmp.add(a.get(step1++));
			else if ((a.get(step1)).compareTo(a.get(step2)) < 0)
				tmp.add(a.get(step1++));
			else if ((a.get(step1)).compareTo(a.get(step2)) >= 0)
				tmp.add(a.get(step2++));

		}

		for (int i = start; i <= end; i++) {
			a.set(i,tmp.get(i-start));
		}
	}

	
	/**
	 * the method gets as parameters an ArrayList of Comparable<Object>
	 * It sorts the array 
	 *    
	 * @param a
	 * 		an ArrayList of Comparable<Object>
	 * @param flag
	 * 		if true - use the more efficient implementation of merge
	 * 		if false - use the less efficient implementation of merge
	 * 
	 *   @return void
	 */
	public static <E extends Comparable<E>> void mergeSort(ArrayList<E> a) {
		mergeSort(a, 0, a.size()-1);
	}

}
