import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by kjs850 on 2016. 10. 17..
 */
public class ThreadTest5 {

	public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {


		ExecutorService executor = Executors.newWorkStealingPool();

		List<Callable<String>> callables = Arrays.asList(
				callable("task1", 2),
				callable("task2", 1),
				callable("task3", 3));

		String result = executor.invokeAny(callables);
		System.out.println(result);

		//task2
	}

	static Callable<String> callable(String result, long sleepSeconds) {
		return () -> {
			TimeUnit.SECONDS.sleep(sleepSeconds);
			return result;
		};
	}

}
