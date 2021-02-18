// java -jar target/example-1.0-SNAPSHOT.jar
package example;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		int[] arr = {1,6,2,10,-1,9,5,12,5,8,9,-2,-1};
		System.out.println(Arrays.toString(arr));
		MergeSortRecursive.mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
