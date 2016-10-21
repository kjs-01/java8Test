import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by kjs850 on 2016. 10. 17..
 */
public class ThreadTest2 {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			String theadName = Thread.currentThread().getName();
			System.out.println("hello " + theadName);
		});

		//hello pool-1-thread-1  , never stop!

		try {
			System.out.println("attempt to shutdown executor");
			executor.shutdown(); //현재 상태에서 마무리 작업을 실행하기위한 대기
			executor.awaitTermination(5, TimeUnit.SECONDS);
		}
		catch (InterruptedException e) {
			System.err.println("tasks interrupted");
		}
		finally {
			if (!executor.isTerminated()) {
				System.err.println("cancel non-finished tasks");
			}
			executor.shutdownNow();  //실행중인 모든 작업을 중단하고 즉시 실행 프로그램을 종료
			System.out.println("shutdown finished");
		}

//		attempt to shutdown executor
//		hello pool-1-thread-1
//		shutdown finished
	}
}
