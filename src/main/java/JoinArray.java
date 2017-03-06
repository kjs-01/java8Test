import java.util.Arrays;
import java.util.stream.Stream;

public class JoinArray {

	public static void main(String[] args) {

		String[] s1 = new String[]{"a", "b", "c"};
		String[] s2 = new String[]{"a", "e", "f"};
		String[] s3 = new String[]{"g", "h", "i"};

		String[] result = Stream.of(s1,s2,s3).flatMap(Stream::of).toArray(String[]::new);
		System.out.println(Arrays.toString(result));



	}
}
