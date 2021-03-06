import java.util.concurrent.*;

/**
 * Created by kjs850 on 2016. 10. 17..
 */
public class ThreadTest3 {

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		Callable<Integer> task = () ->{
			try {
				TimeUnit.SECONDS.sleep(1);
				return 123;
			}catch (InterruptedException e){
				throw new IllegalStateException("task interrupted", e);
			}
		};
		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor.submit(task);

		System.out.println("future done? " + future.isDone());

		Integer result =  future.get();

		System.out.println("future done? " + future.isDone());
		System.out.print("result: " + result);

//		future done? false
//		future done? true
//		result: 123

		executor.shutdownNow();
		//future.get();

	}
}
