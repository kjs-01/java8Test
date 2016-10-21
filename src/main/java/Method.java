import java.util.ArrayList;
import java.util.List;

/**
 * Created by kjs850 on 2016. 6. 3..
 */
public class Method {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("Mahesh");
		names.add("Suresh");
		names.add("Ramesh");
		names.add("Naresh");
		names.add("Kalpesh");

		names.forEach(System.out::println);
	}
}
