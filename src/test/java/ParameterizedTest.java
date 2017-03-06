import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(value = Parameterized.class)
public class ParameterizedTest {

	//default value = 0
	@Parameterized.Parameter(value = 0)
	public int numberA;

	@Parameterized.Parameter(value = 1)
	public int numberB;

	@Parameterized.Parameter(value = 2)
	public int expected;


	@Parameterized.Parameters(name="{index}: testAdd({0}+{1}) = {2})")
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{1, 1, 2},
			{2, 2, 4},
			{8, 2, 10},
			{4, 5, 9},
			{5, 5, 10}
		});
	}


	@Test
	public void test_addTwoNumbers(){
		assertThat(MathUtils.add(numberA, numberB), is(expected));
	}



}
