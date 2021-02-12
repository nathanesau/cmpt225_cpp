// java -jar target/example-1.0-SNAPSHOT.jar
package example;

import java.util.LinkedList;
import java.util.Iterator;
import example.geometricshapes.GeometricShape;

public class App 
{
    public static void main( String[] args )
    {
        GeometricShapeFactory factory = new GeometricShapeFactory();
		
		LinkedList<GeometricShape> list = new LinkedList<GeometricShape>();
		list.add(factory.createShape("circle"));
		list.add(factory.createShape("square"));
		list.add(factory.createShape("rectangle"));
		
		Iterator<GeometricShape> iterator = null;
		for (iterator = list.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
			
		}
    }
}
