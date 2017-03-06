import java.util.Arrays;

/**
 * Created by kjs850 on 2016. 10. 26..
 */
public class TestStudent {

	public static void main(String[] args) {

		Student s = new Student.Builder()
				.name("jj")
				.age(30)
				.language(Arrays.asList("korean", "english"))
				.build();

		System.out.println(s);
	}
}
