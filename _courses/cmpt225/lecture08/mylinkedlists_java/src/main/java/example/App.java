// java -jar target/example-1.0-SNAPSHOT.jar
package example;

public class App 
{
    public static void main( String[] args )
    {
		MyLinkedList<String> strings = new MyLinkedList<String>();
		strings.addToHead("ABC");
		strings.addToHead("XYZ");
		strings.addToHead("BC");
		strings.addToHead("FGC");
		strings.addToHead("ABC");
		strings.addToHead("ABC");
		strings.addToHead("123");
		strings.addToHead("456");
		strings.addToHead("ABC");
		strings.addToHead("ABC");
		strings.addToTail("000");
		strings.addToTail("111");
		strings.addToTail("222");
		
		System.out.println(strings);
		
		System.out.println("removeAllOccurences(\"ABC\");");
		strings.removeAllOccurences("ABC");
		System.out.println(strings);

		System.out.println("remove head and tail");
		System.out.println(strings);
		
		strings.set(3, "NEW-ELT");

		System.out.println("strings[0] = " +strings.get(0));
		System.out.println("strings[3] = " +strings.get(3));
    }
}
