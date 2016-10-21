import java.util.Optional;

/**
 * Created by kjs850 on 2016. 10. 10..
 */
public class OptionalExample {

	public static void main(String[] args) {

		OptionalExample optionalExample = new OptionalExample();
		Integer value1 = null;
		Integer value2 = new Integer(10);

		Optional<Integer> a = Optional.ofNullable(value1);

		Optional<Integer> b = Optional.of(value2);
		System.out.println(optionalExample.sum(a,b));

		Optional<String> code = Optional.empty();
		System.out.println("code: " + code);
		//code = Optional.of(null); //java.lang.NullPointerException
//		code = Optional.ofNullable(null);
		code = Optional.of("test code");
		System.out.println("code is present: " + code.isPresent());
		System.out.println("code is get: " + code.orElse("null Str"));
	}

	private Integer sum(Optional<Integer> a, Optional<Integer> b) {


		System.out.println("First parameter: " + a);
		System.out.println("Second parameter: " + b);
		//Optional.isPresent - checks the value is present or not

		System.out.println("First parameter is present: " + a.isPresent());
		System.out.println("Second parameter is present: " + b.isPresent());

		//Optional.orElse - returns the value if present otherwise returns
		//the default value passed.
		Integer value1 = a.orElse(new Integer(0));
//		Integer value1 = a.get();  //java.util.NoSuchElementException: No value present

		//Optional.get - gets the value, value should be present
		Integer value2 = b.get();
		return value1 + value2;
	}


}
