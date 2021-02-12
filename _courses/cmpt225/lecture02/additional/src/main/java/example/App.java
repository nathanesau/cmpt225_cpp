// java -jar target/example-1.0-SNAPSHOT.jar
package example;

// OK can import public class
import example.maths.AlgebraicOperations;

// PROBLEM cannot import non-public class outside of its package
//import example.stats.RandomNumberGenerator;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("1+1=" + AlgebraicOperations.sum(1, 1));
        System.out.println("1x1=" + AlgebraicOperations.multiply(1, 1));
        //System.out.println("randomFloat=" + RandomNumberGenerator.randomFloat());
        //System.out.println("randomInt=" + RandomNumberGenerator.randomInt());
    }
}
