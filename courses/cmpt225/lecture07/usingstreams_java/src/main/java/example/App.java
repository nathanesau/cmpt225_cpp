// java -jar target/example-1.0-SNAPSHOT.jar
package example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Stream;

public class App 
{
    public static boolean isPowerOfTwo(int n) {
		if (n==1)
			return true;
		if (n%2 == 1)
			return false;
		return isPowerOfTwo(n/2);
	}
	
	public static ArrayList<Integer> createArrayList()
	{
		ArrayList<Integer> arrayOfInts = new ArrayList<Integer>(10);

		// array.set(0,1); // wrong! length of the array is still 0 
		// (not the same as initial capacity is 10)

		arrayOfInts.add(1); // adds 1 to array[0]
		arrayOfInts.add(2); // adds 2 to array[1]
		for (int i = 2; i <= 10; i++) {
			arrayOfInts.add(i);
			arrayOfInts.add(arrayOfInts.get(arrayOfInts.size()-2)*2);
		}
		arrayOfInts.add(1024);
		arrayOfInts.set(arrayOfInts.size()-2, 2048);
		
		return arrayOfInts;
	}
	
	public static void useStreams() {

		ArrayList<Integer> arrayInts = createArrayList();
		// debug to see what's inside the arrayOfInts

		System.out.println("Print using println: ");
		System.out.println(arrayInts);

		System.out.println("\nPrint using iterators:");
		Iterator<Integer> it = arrayInts.iterator();
		it.forEachRemaining(num -> System.out.print(num + " "));
		System.out.println("\n");

		System.out.println("\nPrint using stream:");
		Stream<Integer> str = arrayInts.stream();
		str.forEach(num -> System.out.print(num + " "));
		System.out.println("\n");

		// a more succinct way to do it
		System.out.println("\nPrint using stream:");
		arrayInts.stream()
			.forEach(num -> System.out.print(num + " "));
		System.out.println("\n");

		// print a[i]+1000 for all i
		// does not affect the actual array
		System.out.println("Print a[i]+1000:");
		arrayInts.stream()
			.map(n -> n+1000)
			.forEach(num -> System.out.print(num + " "));
		System.out.println("\n");
		// easier than writing 
		// Stream<Integer> str2= arrayOfInts.stream();
		// str2 = str2.map(n -> n+1000);
		// str2.forEach(n -> System.out.print(n + " "));

		// print only odds
		// does not affect the original arrayInts
		System.out.println("Print only odds:");
		arrayInts.stream()
			.filter(n -> n%2 == 1)
			.forEach(num -> System.out.print(num + " "));
		System.out.println("\n");

		// print only powers of 2
		// does not affect the original arrayInts
		System.out.println("Print only powers of 2:");
		arrayInts.stream()
			.filter(n -> isPowerOfTwo(n))
			.forEach(num -> System.out.print(num + " "));
		System.out.println("\n");

		// print only odds + 1000
		// does not affect the original arrayInts
		System.out.println("Print only odds + 1000:");
		arrayInts.stream()
			.filter(n -> n%2 == 1)
			.map(n -> n+1000)
			.forEach(num -> System.out.print(num + " "));
		System.out.println("\n");

		// compute the sum of all even numbers using filter + reduce
		System.out.print("Sum of all even numbers is: ");
		int sum = arrayInts.stream()
			.filter(n -> n%2==0)
			.reduce(1, (a,b) -> a+b);
		System.out.println(sum + "\n");

		// print sorted in reverse order
		System.out.println("Print sorted in reverse order:");
		arrayInts.stream()
			.sorted(Comparator.reverseOrder())
			.forEach(num -> System.out.print(num + " "));
		System.out.println("\n");
		
		// print sorted distinct powers of 2
		System.out.println("Print sorted distinct powers of 2:");
		arrayInts.stream()
			.filter(App::isPowerOfTwo) // same as n -> App.isPowerOfTwo 
			.distinct()
			.sorted()
			.forEach(num -> System.out.print(num + " "));
		System.out.println("\n");
	}

	public static void useSummaryStatistics() {
		Person simplePeople[] = new Person[7];
		simplePeople[0] = new Person("Bruce ", "Wayne", 30);
		simplePeople[1] = new Person("Peter ", "Parker", 30);
		simplePeople[2] = new Person("Steve", "Rogers", 20);
		simplePeople[3] = new Person("Tony", "Stark", 25);
		simplePeople[4] = new Person("Clark", "Kent", 20);
		simplePeople[5] = new Person("Billy", "Batson", 35);
		simplePeople[6] = new Person("Scott","Summers", 40);
		
		System.out.println(Arrays.stream(simplePeople)
				.mapToInt(person -> ((Person)person).getAge())
				.summaryStatistics());

		System.out.println("min = " +
				Arrays.stream(simplePeople)
				.mapToInt(person -> ((Person)person).getAge())
				.summaryStatistics()
				.getMin());


		System.out.println("max = " +
				Arrays.stream(simplePeople)
				.mapToInt(person -> ((Person)person).getAge())
				.summaryStatistics()
				.getMax());
	}

    public static void main( String[] args )
    {
        useStreams();
        useSummaryStatistics();
    }
}
