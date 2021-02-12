// java -jar target/example-1.0-SNAPSHOT.jar
package example;

import example.coffee.Coffee;
import example.coffee.Person;
import example.coffee.TooColdException;
import example.coffee.TooHotException;
import example.geometry.Circle;
import example.geometry.Point;

public class App 
{
	public static void geometryTest() {

		Point p1 = new Point(1, 10);
		Circle c1 = new Circle(p1,5);
		try {
			c1.setRadius(-3);
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("error message:  \n" + e.getMessage());
			
			System.out.println("-------");
			
			System.out.println("e.toString(): \n" +e.toString());
			
			System.out.println("-------");

			System.out.println("e.printStackTrace(): ");
			e.printStackTrace();	
			System.out.println("-------");
			System.out.println("Stacks Trace:");
			StackTraceElement[] stackTrace = e.getStackTrace();
			for(StackTraceElement elt : stackTrace)
				System.out.println(elt.toString());
			
		}
	}

	// helper function for coffeeTest
	public static void serveCustomer(Person customer, Coffee cup)
    {

    	try {
            customer.drinkCoffee(cup);
            System.out.printf("%s's coffee is just right.\n", customer.getName());
        }
        catch (TooColdException e) {
            System.out.printf("%s's coffee is too cold.\n", customer.getName());
            // Deal with the customer...
        }
        catch (TooHotException e) {
            System.out.printf("%s's coffee is too hot.\n", customer.getName());
            System.out.println("The error message is:\n" +e.getMessage());
            // Deal with the customer...
        }
    	finally {
			System.out.println("Clear the table");
		}
    }

	public static void coffeeTest() {
		Coffee coffee = new Coffee(Coffee.JUST_RIGHT);
		Coffee coldCoffee = new Coffee(Coffee.TOO_COLD);
		Coffee hotCoffee = new Coffee(Coffee.TOO_HOT);
		
		Person p = new Person("John");
		
		serveCustomer(p,coffee);
		System.out.println("-----------");
		serveCustomer(p,coldCoffee);
		System.out.println("-----------");
		serveCustomer(p,hotCoffee);
	}

    public static void main( String[] args )
    {
        geometryTest();
		coffeeTest();
    }
}
