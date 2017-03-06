import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by kjs850 on 2016. 11. 1..
 */
public class Exception2Test {
	@Test
	public void testDivisionWithException() {
		try {
			int i = 1 / 0;
			fail(); //remember this line, else 'may' false positive
		} catch (ArithmeticException e) {
			e.printStackTrace();
			assertThat(e.getMessage(), is("/ by zero"));
			//assert others
		}
	}
}
