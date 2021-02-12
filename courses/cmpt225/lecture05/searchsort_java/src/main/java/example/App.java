// java -jar target/example-1.0-SNAPSHOT.jar
package example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class App {
    public static ArrayList<MyComparableClass> getRandomArray(int size) {
        ArrayList<MyComparableClass> randArray = new ArrayList<MyComparableClass>(size);

        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            randArray.add(new MyComparableClass(rand.nextInt(1000), "Str"));
        }
        return randArray;
    }

    public static <E> void printArray(ArrayList<E> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.print("a[" + i + "]=" + a.get(i).toString() + " ");
        }
        System.out.println("");
    }

    public static void testSort() {
        int array[] = new int[20];
		
		Random r = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(100);
			System.out.print(array[i] + " ");
		}

		System.out.println("\n---Sorting...\n\n");
		Arrays.sort(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
    }

    public static void testMergeSort() {

        int size = 10;
        ArrayList<MyComparableClass> a = getRandomArray(size);

        System.out.println("Orig arrray:");
        printArray(a);

        System.out.println("Sorting...");
        MergeSort.mergeSort(a);

        System.out.println("Sorted array:");
        printArray(a);
    }
    
    public static void testSearchSorted() {
        int size = 50;
		ArrayList<MyComparableClass> a = getRandomArray(size);

		System.out.println("Orig a:");
		printArray(a);
	
		MergeSort.mergeSort(a);

		System.out.println("Sorted a:");
		printArray(a);
	
		MyComparableClass element = new MyComparableClass((new Random()).nextInt(1000),"Str");

		System.out.println(element);
		int ind = SearchSorted.findElement(a, element);
		if (ind>-1)
			System.out.println("found " + element + " at index " + ind);
		else
			System.out.println("element " + element + " not found");
    }

    public static void testSearchUnsorted() {
        int size = 20;
		ArrayList<MyComparableClass> a = getRandomArray(size);
		
		printArray(a);
	
		
		for (int j = 0; j < 10; j++) {
			MyComparableClass element = new MyComparableClass(j, "Str");
			int ind = SearchUnsorted.findElement(a, element);
			if (ind>-1)
				System.out.println("found " + element + ": a[" + ind + "] = " + element);
			else
				System.out.println("element " + element + " not found");
		}
    }

    public static void main(String[] args) {
        testSort();
        testMergeSort();
        testSearchSorted();
        testSearchUnsorted();
    }
}
