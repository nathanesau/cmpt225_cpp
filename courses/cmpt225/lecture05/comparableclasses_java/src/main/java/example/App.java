// java -jar target/example-1.0-SNAPSHOT.jar
package example;

import java.util.Arrays;

public class App 
{
    public  static void testMyComparableClass1() {
        MyComparableClass1[] c = new MyComparableClass1[5];
		c[0] = new MyComparableClass1(0,"ABC");
		c[1] = new MyComparableClass1(1,"ABC");
		c[2] = new MyComparableClass1(2,"ABC");
		c[3] = new MyComparableClass1(1,"XYZ");
		c[4] = new MyComparableClass1(2,"ABC");

		if (c[1].compareTo(c[2]) > 0)
			System.out.printf("c[1] > c[2] \n");
		else if (c[1].compareTo(c[2]) < 0)
			System.out.printf("c[1] < c[2] \n");
		else
			System.out.printf("c[1] == c[2] \n");
	
		System.out.printf("Sorting the array:...\n");
		Arrays.sort(c);
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i].toString());
		}
		System.out.printf("\n");
    }

    public static void testMyComparableClass2() {

        MyComparableClass2 c = new MyComparableClass2(2,"ABC");

    
        MyComparableClass1 other = new MyComparableClass1(1, "RST");
        if (c.compareTo(other) > 0)
            System.out.printf("c > other \n");
        else if (c.compareTo(other) < 0)
            System.out.printf("c < other \n");
        else
            System.out.printf("c == other \n");
        
        // Does not compile
        //if (c.compareTo(c) > 0) {
        //System.out.printf("c > c \n");
        //}
    }

    public static void testMyComparableClass3() {
        MyComparableClass3[] c = new MyComparableClass3[5];
		c[0] = new MyComparableClass3(1,"ABC");
		c[1] = new MyComparableClass3(2,"ABC");
		c[2] = new MyComparableClass3(3,"ABC");
		c[3] = new MyComparableClass3(4,"ABC");
		c[4] = new MyComparableClass3(2,"XYZ");

		IncomparableClass1 i1 = new IncomparableClass1(10, "QRS");

		if (c[1].compareTo(i1) > 0)
			System.out.printf("c[1] > i1 \n");
		else if (c[1].compareTo(i1) < 0)
			System.out.printf("c[1] < i1 \n");
		else
			System.out.printf("c[1] == c[2] \n");
    }

    public static void testMyComparableClass4() {
        MyComparableClass4[] c = new MyComparableClass4[5];
		c[0] = new MyComparableClass4(0,"ABC");
		c[1] = new MyComparableClass4(1,"ABC");
		c[2] = new MyComparableClass4(2,"EFG");
		c[3] = new MyComparableClass4(4,"ABC");
		c[4] = new MyComparableClass4(2,"EFG");

		MyInterface inc1 = new IncomparableClass2(1, "QRS");
		IncomparableClass2 inc2 = new IncomparableClass2(3, "ABC");

		if (c[1].compareTo(inc1) > 0)
			System.out.printf("c[1] > inc1 \n");
		else if (c[1].compareTo(inc1) < 0)
			System.out.printf("c[1] < inc1 \n");
		else
			System.out.printf("c[1] == inc1 \n");
		

		if (c[2].compareTo(inc2) > 0)
			System.out.printf("c[2] > inc2 \n");
		else if (c[2].compareTo(inc2) < 0)
			System.out.printf("c[2] < inc2 \n");
		else
			System.out.printf("c[2] == inc2 \n");

        // on the other hand:		
        //inc1.compareTo(c[0]) //Will not compile
        //inc2.compareTo(c[0]) //Will not compile
		
		//*********************************************//
		System.out.printf("Sorting the array:...\n");
		Arrays.sort(c);
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i].toString());
		}
		System.out.printf("\n");
    }

    public static void testPoint() {
        Point p1 = new Point(1,4);
		Point p2 = new Point(0,2);
		if (p1.compareTo(p2) > 0)
			System.out.println("dist(" + p1 + ",origin) < dist(" + p2 + ",origin)");
		else if  (p1.compareTo(p2) < 0)
			System.out.println("dist(" + p1 + ",origin) > dist(" + p2 + ",origin)");
		else
			System.out.println("dist(" + p1 + ",origin) < dist(" + p2 + ",origin)");
		
		Point p3 = new Point(0,2);
		System.out.println("-------------");
		if (p2 == p3)
			System.out.println("p2 and p3 are the same point");
		else
			System.out.println("p2 and p3 are different points");

		System.out.println("-------------");
		if (p2.equals(p3))
			System.out.println("p2.equals(p3) = true");
		else
			System.out.println("p2.equals(p3) = false");
    }

    public static void testEqualsClass() {
        EqualsClass c1 = new EqualsClass(0, "ABC");
		System.out.println("class of c1 is : " + c1.getClass());

		EqualsClass c2 = new EqualsClass(0, "ABC");
		System.out.println("c1 and c2 are the same object: " + (c1 == c2));
		System.out.println("c1.equals(c2) = " + c1.equals(c2));

		System.out.println("-------------------------------------");

		String s1 = "ABC";
		String s2 = "ABC";
		System.out.println("s1.equals(s2) = " + s1.equals(s2));
		System.out.println("s1 and s2 are the same object : " + (s1 == s2));

		System.out.println("-------------------------------------");

		String s3 = new String("ABC");
		System.out.println("s1.equals(s3) = " + s1.equals(s3));
		System.out.println("s1 and s3 are the same object : " + (s1 == s3));
    }

    public static void main( String[] args )
    {
        testMyComparableClass1();
        testMyComparableClass2();
        testMyComparableClass3();
        testMyComparableClass4();
        testPoint();
        testEqualsClass();
    }
}
