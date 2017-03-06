import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

public class TimeoutTest{

	//http://www.mkyong.com/unittest/junit-4-tutorial-4-time-test/
//	@Test(timeout = 1000)
//	public void infinity(){
//		while(true);
//	}

	//global timeout rule
	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	@Test
	public void testSlowMethod1() throws InterruptedException{
		TimeUnit.SECONDS.sleep(5000);
	}


}
