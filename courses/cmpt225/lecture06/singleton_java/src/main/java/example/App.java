// java -jar target/example-1.0-SNAPSHOT.jar
package example;

public class App 
{
	public static void testSingleton1() {
		Singleton1 s1 = Singleton1.getInstance();
		Singleton1 s2 =  Singleton1.getInstance();
		System.out.println("the objects are equal:" + (s1 == s2));
	}

	public static void testSingleton2() {
		Singleton2 s1 = Singleton2.getInstance();
		Singleton2 s2 =  Singleton2.getInstance();
		System.out.println("the objects are equal:" + (s1 == s2));
	}

    public static void main( String[] args )
    {
		testSingleton1();
		testSingleton2();
    }
}
