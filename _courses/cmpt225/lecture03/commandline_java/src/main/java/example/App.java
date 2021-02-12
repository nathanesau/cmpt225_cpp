// java -jar target/example-1.0-SNAPSHOT.jar
package example;

import java.util.Random;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("The number of arguments is " + args.length);
		System.out.println("----------------");
		
		for (int i = 0; i < args.length; i++)
			System.out.println("arg[" + i +"] = " + args[i]);
    }
}
