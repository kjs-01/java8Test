import com.sun.tools.corba.se.idl.StringGen;

/**
 * Created by kjs850 on 2016. 6. 3..
 */
public class Scope {

	final static String sal = "Hello ";

	public static void main(String[] args) {
		GreetingService  greetingService1 = message -> System.out.println( sal + message);
		greetingService1.say("aa");
	}

	interface GreetingService{
		void say(String msg);
	}
}
