// java -jar target/example-1.0-SNAPSHOT.jar
package example;

import java.util.Random;

import example.animals.Animal;
import example.animals.Cow;
import example.animals.Dog;

public class App 
{
    public static Animal createRandomAnimal()
	{
		Random r = new Random();
		switch (r.nextInt(3)) {
			case 0:
				return new Cow("Pink", "name" + r.nextInt(10), r.nextInt(200) );
			case 1:
				return new Dog("Spaniel", "Blue", "name" + r.nextInt(100));
			case 2:
				return new Dog("Shepherd", "Gold", "name" + r.nextInt(100));
		}
		return null;
	}

    public static void main( String[] args )
    {
        Animal[] array = new Animal[5];
		for (int i = 0; i < array.length; i++) {
			array[i] = createRandomAnimal();
		}

		for (Animal animal : array) {
			System.out.print(animal + " says ");
			System.out.println(animal.makeSound());
		}
    }
}
