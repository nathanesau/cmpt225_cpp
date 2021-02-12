package example;

import java.util.Random;

public class Singleton1 {

	int val;
	// other data fields
	
	// the unique instance
	private static Singleton1 theUniqueInstance = new Singleton1();
	
	private Singleton1()	{
		//init
		val = new Random().nextInt(100);
	}
	
	public static Singleton1 getInstance()	{
		return theUniqueInstance;
	}

	public void printVal()
	{
		System.out.println("val = " + val);
	}
	
}
