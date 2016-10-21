import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by kjs850 on 2016. 10. 18..
 */
public class CompletableFutureTest4 {

	//http://stackoverflow.com/questions/35329845/difference-between-completablefuture-future-and-observable-rxjava
	/**
	 * A task that sleeps for a second, then returns 1
	 **/
	public static class MyCallable implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			Thread.sleep(1000);
			return 1;
		}

	}

	public static void main(String[] args) throws Exception{
		ExecutorService exec = Executors.newSingleThreadExecutor();
		Future<Integer> f = exec.submit(new MyCallable());

		System.out.println(f.isDone()); //False

		System.out.println(f.get()); //Waits until the task is done, then prints 1


	}


}
