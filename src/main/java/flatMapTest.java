import java.util.Arrays;
import java.util.stream.Stream;
/**
 * Created by kjs850 on 2016. 10. 21..
 */
public class flatMapTest {

	//https://www.mkyong.com/java8/java-8-flatmap-example/S
	public static void main(String[] args) {

		String[][] data =  new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

		//Stream<String[]>
		Stream<String[]> temp = Arrays.stream(data);
		//temp.forEach(System.out::println);

		//filter a stream of string[], and return a string[]?
//		Stream<String[]> stream = temp.filter(x -> "a".equals(x.toString()));
//		stream.forEach(System.out::println);

		Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x)).filter(x -> "a".equals(x.toString()));

		stringStream.forEach(System.out::println);
	}
}
