// java -jar target/example-1.0-SNAPSHOT.jar
package example;

import java.awt.Color;

public class App 
{
    public static void main( String[] args )
    {
        Bicycle c = new Bicycle(Color.BLUE, 20, 20);

		for (int i = 0; i < 10; i++) {
			c = new Bicycle(Color.BLUE, 20, 20);
		}

		System.out.println(c.toString());
		
		System.out.println("So far created " +Bicycle.getNumberOfCreatedBicycles() + " bicycles");

		System.out.println("--------------");

		Bicycle[] d = new Bicycle[10];
		for (int i = 0; i < 10; i++) {
			d[i] = new Bicycle(Color.BLUE, 20, 20);
		}
		System.out.println("So far created " +Bicycle.getNumberOfCreatedBicycles() + " bicycles");

		System.out.println("--------------");

		System.gc(); 
		System.out.println("So far created " +Bicycle.getNumberOfCreatedBicycles() + " bicycles");
    }
}
