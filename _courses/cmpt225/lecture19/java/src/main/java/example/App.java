// java -jar target/example-1.0-SNAPSHOT.jar
package example;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
		Heap<Integer> heap = new Heap<Integer>();
		heap.add(4);
		heap.add(1);
		heap.add(6);
		heap.add(8);
		heap.add(2);
		heap.add(3);
		heap.add(5);
		heap.add(7);
		heap.add(9);
		//  	   1 
		//     2      3
		//   7   4  6   5
		//  8 9
		System.out.println(heap.array);
		heap.removeMin();
		//  	  2 
		//     4      3
		//   7   9  6   5
		//  8
		System.out.println("removed 1: " + heap.array);

		heap.removeMin();
		//  	 3 
		//    4     5
		//   7 9   6 8
		System.out.println("removed 2: " + heap.array);

		heap.removeMin();
		//  	 4 
		//    7     5
		//   8 9   6   
		System.out.println("removed 4: " + heap.array);

		System.out.println("--------------");


		ArrayList<Integer> listOfNnumbers = new ArrayList<Integer>();
		listOfNnumbers.addAll(Arrays.asList(9,7,6,8,3,4,2,5,0,1));

		System.out.println("Build heap from " + listOfNnumbers);

		// the block below kinda awkward - it requires creating Heap just to sort a list 
		Heap<Integer> heap2 = new Heap<Integer>(listOfNnumbers);
		// represents the tree:
		//             9
		//         7       6
		//       8   3   4   2
		//      5 0 1 
		//

		heap2.heapSort();
		System.out.println("After heapSort: " + heap2);
		listOfNnumbers = new ArrayList<Integer>();
		listOfNnumbers.addAll(Arrays.asList(9,7,6,8,3,4,2,5,0,1));
		
		// This one is better 
		Heap.heapSort(listOfNnumbers);
		System.out.println("After static heapSort: " + listOfNnumbers);
    }
}
