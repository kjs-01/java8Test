/**
 * Created by kjs850 on 2016. 6. 1..
 */
public class Calculator {

	public static void main(String[] args) {
		Calculator tester = new Calculator();

		MathOperation add = (int a, int b ) -> a + b;

		MathOperation sub = (a, b) -> a - b;

		MathOperation multi = (int a, int b ) -> { return a * b; };

		System.out.println(tester.operrate(10,5, add));
		System.out.println(tester.operrate(10,5, sub));

		GreetingService greetService1 = (message) ->	System.out.println("Hello " + message);

//		GreetingService aaa = new GreetingService() {
//			@Override
//			public void sayMessage(String message) {
//
//			}
//		} ;

		greetService1.sayMessage("Mahesh");

	}

	@FunctionalInterface
	interface GreetingService {
		void sayMessage(String message);
	}

	private int operrate(int a, int b, MathOperation mathOperation){
		return mathOperation.operation( a, b);
	}


}
