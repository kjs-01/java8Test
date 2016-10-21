import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kjs850 on 2016. 10. 18..
 */
public class CompletableFutureTest {

	//http://wiki.daumkakao.com/pages/viewpage.action?pageId=370733240

	public static void main(String[] args) throws Exception{

		ExecutorService executorService = Executors.newCachedThreadPool();
		long startTime = System.currentTimeMillis();

		CompletableFuture cf1 = CompletableFuture.supplyAsync(()->{
			try{Thread.sleep(5000);} catch(Exception ex){};
			System.out.println("cf1 supplyAsync on thread "+Thread.currentThread().getId()+" now="+(System.currentTimeMillis()-startTime));
			return 100;
		});

		CompletableFuture cf2 = CompletableFuture.supplyAsync(()->{
			try{Thread.sleep(2000);} catch(Exception ex){};
			System.out.println("cf2 supplyAsync on thread "+Thread.currentThread().getId()+" now="+(System.currentTimeMillis()-startTime));
			return 200;
		});

		CompletableFuture cf3 = CompletableFuture.supplyAsync(() -> {
			try{Thread.sleep(8000);} catch(Exception ex){};
			System.out.println("cf3 supplyAsync on thread "+Thread.currentThread().getId()+" now="+(System.currentTimeMillis()-startTime));
			return 300;
		},executorService);

		System.out.println("Task execution requested on thread " + Thread.currentThread().getId());
		cf3.thenComposeAsync((data1) -> {
			System.out.println(data1);
			return cf2;
		}).thenComposeAsync( (data2)->cf1).join();

		System.out.println("final cf1.get() = " + cf1.get() + " cf2.get()=" + cf2.get() + " cf3.get()=" + cf3.get() + " now=" + (System.currentTimeMillis() - startTime));



	}
}
