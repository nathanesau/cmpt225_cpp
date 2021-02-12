package example;

import java.util.ArrayList;

public class SearchUnsorted {


	/**
	 * search for an element in the given array of integers
	 * 
	 * @param a - an array
	 * 
	 * @param element - an integer
	 * 
	 * @return
	 * 		the index in the array that contains the given element
	 * 		if element is not in the array, returns -1
	 */
	public static <E> int findElement(ArrayList<E> a, E element) {
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).equals(element))
				return i;
		}
		return -1;
	}

}
