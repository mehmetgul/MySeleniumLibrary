package mehmetgul.mylib.xxxothers;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Important Points/Observations:
 *
 * A stream consists of source followed by zero or more intermediate methods
 * combined together (pipelined) and a terminal method to process the objects
 * obtained from the source as per the methods described.
 * Stream is used to compute elements as per the pipelined methods without
 * altering the original value of the object.
 */

/**
 * collect:
 * The collect method is used to return the result of the intermediate operations performed on the stream.
 * List number = Arrays.asList(2,3,4,5,3);
 * Set square = number.stream().map(x->x*x).collect(Collectors.toSet());
 *
 * forEach:
 * The forEach method is used to iterate through every element of the stream.
 * List number = Arrays.asList(2,3,4,5);
 * number.stream().map(x->x*x).forEach(y->System.out.println(y));
 *
 * reduce:
 * The reduce method is used to reduce the elements of a stream to a single value.
 * The reduce method takes a BinaryOperator as a parameter.
 * List number = Arrays.asList(2,3,4,5);
 * int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
 *
 * Here ans variable is assigned 0 as the initial value and i is added to it .
 */
public class JavaTest {

	@Test
	public void streamTest() {
		// create a list of integers
		List<Integer> number = Arrays.asList(2, 3, 4, 5);

		// demonstration of map method
		List<Integer> square = number.stream().map(x -> x * x).
				collect(Collectors.toList());
		System.out.println(square);

		// create a list of String
		List<String> names =
				Arrays.asList("Reflection","Collections", "Collection", "Stream");

		// demonstration of filter method
		List<String> result = names.stream().filter(s -> s.startsWith("S")).
				collect(Collectors.toList());
		System.out.println(result);

		// demonstration of sorted method
		List<String> show =
				names.stream().sorted().collect(Collectors.toList());
		System.out.println(show);

		// create a list of integers
		List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 2);

		// collect method returns a set
		Set<Integer> squareSet =
				numbers.stream().map(x -> x * x).collect(Collectors.toSet());
		System.out.println("collect method returns a set "+squareSet);

		// demonstration of forEach method
		number.stream().map(x -> x * x).forEach(y -> System.out.print(y+" "));

		// demonstration of reduce method
		int even =
				number.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);
		System.out.println();
		System.out.println("demonstration of reduce method " +even);


		// Creating a String array
		String[] arr = { "Geeks", "for", "Geeks" };

		// Using Arrays.stream() to convert
		// array into Stream
		Stream<String> stream = Arrays.stream(arr);

		// Displaying elements in Stream
		stream.forEach(str -> System.out.print(str + " "));
	}

}
