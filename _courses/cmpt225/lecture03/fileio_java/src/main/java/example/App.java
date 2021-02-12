// java -jar target/example-1.0-SNAPSHOT.jar
package example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Scanner;

public class App {
	public static void useBufferedReader(InputStream is) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(is));

		// read the first line and print it
		String s = input.readLine();
		System.out.println(s);

		// for other lines parse them into string, string, int
		s = input.readLine();
		while (s != null) {
			String[] tokens = s.split(" ");
			int grade = Integer.parseInt(tokens[2]);
			System.out.println(tokens[0] + " " + tokens[1] + " " + grade);
			// C-style print format is also possible
			// System.out.printf("%s, %s, %d\n", tokens[0], tokens[1], grade);
			s = input.readLine();
		}

		// Close the file
		input.close();
	}

	public static void useScanner(InputStream is) throws FileNotFoundException {

		Scanner reader = new Scanner(is);

		String s = reader.nextLine();
		System.out.println(s);
		// read data from the input file
		while (reader.hasNext()) {
			String firstName = reader.next();
			String lastName = reader.next();
			int grade = reader.nextInt();
			System.out.println(firstName + " " + lastName + " " + grade);
		}

		// Close the file
		reader.close();

	}

	public static void main(String[] args) throws URISyntaxException, FileNotFoundException, Exception {

		System.out.println("Loading file...");

		InputStream stream = App.class.getClassLoader().getResourceAsStream("mytext.txt");
		useScanner(stream);
		// stream is closed

		stream = App.class.getClassLoader().getResourceAsStream("mytext.txt");
		useBufferedReader(stream);
		// stream is closed
	}
}
