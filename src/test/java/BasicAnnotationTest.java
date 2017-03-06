import org.junit.*;

public class BasicAnnotationTest {

	//http://www.mkyong.com/unittest/maven-and-junit-example/
	//http://www.mkyong.com/unittest/junit-4-tutorial-1-basic-usage/
	@BeforeClass
	public static void runOnceBeforeClass() {
		System.out.println("@BeforeClass - runOnceBeforeClass");
	}

	@AfterClass
	public static void runOnceAfterClass() {
		System.out.println("@AfterClass - runOnceAfterClass");

	}

	@Before
	public void before() {
		System.out.println("BasicAnnotationTest.before");
	}

	@After
	public void after() {
		System.out.println("BasicAnnotationTest.after");
	}

	@Test
	public void test1() {
		System.out.println("BasicAnnotationTest.Test");
	}

	@Test
	public void test2() {
		System.out.println("BasicAnnotationTest.test2");
	}


}
