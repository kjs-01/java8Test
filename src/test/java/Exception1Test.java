import org.junit.Test;

import java.util.ArrayList;

//http://www.mkyong.com/unittest/junit-4-tutorial-2-expected-exception-test/
public class Exception1Test {

	@Test(expected = ArithmeticException.class)
	public void testDivisionWithException(){
		int i = 1 / 0;
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testEmptyList(){
		new ArrayList<>().get(0);
	}
}
