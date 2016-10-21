import java.util.concurrent.TimeUnit;

/**
 * Created by kjs850 on 2016. 10. 17..
 */
public class ThreadTest {

	public static void main(String[] args) {

//		Runnable task = () ->{
//			String threadName = Thread.currentThread().getName();
//			System.out.println("hello " + threadName);
//		};
//
//		task.run();
//
//		Thread thread = new Thread(task);
//		thread.start();
//
//		System.out.println("Done!");

//case #1
//		Hello main
//		Hello Thread-0
//		Done!

//case #2
//		hello main
//		Done!
//		hello Thread-0

		Runnable runnable = () -> {
			try {
				String name = Thread.currentThread().getName();
				System.out.println("Foo " + name);
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Bar " + name);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();

//		Foo Thread-0
//		Bar Thread-0
	}
}
