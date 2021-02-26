// java -jar target/example-1.0-SNAPSHOT.jar
package example;

import java.util.List;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
		Heap<Integer> heap1 = new Heap<Integer>();
		heap1.add(4);
		heap1.add(1);
		heap1.add(6);
		heap1.add(8);
		heap1.add(2);
		heap1.add(3);
		heap1.add(5);
		heap1.add(7);
		heap1.add(9);
		//  	   1 
		//     2      3
		//   7   4  6   5
		//  8 9
		heap1.removeMin();
		//  	  2 
		//     4      3
		//   7   9  6   5
		//  8
		System.out.println(heap1.array);

		heap1.removeMin();
		//  	 3 
		//    4     5
		//   7 9   6 8
		System.out.println(heap1.array);

		heap1.removeMin();
		//  	 4 
		//    7     5
		//   8 9   6   
		System.out.println(heap1.array);

		System.out.println("--------------");
		

		List<Integer> arrayList = Arrays.asList(9,3,6,8,2,4,1);
		Heap<Integer> heap2 = new Heap<Integer>(arrayList);
		System.out.println(heap2);
    }
}
