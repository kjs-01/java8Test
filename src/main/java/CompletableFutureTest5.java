import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by kjs850 on 2016. 10. 18..
 */
public class CompletableFutureTest5 {

	//http://stackoverflow.com/questions/35329845/difference-between-completablefuture-future-and-observable-rxjava
	public static class MySupplier implements Supplier<Integer>{
		@Override
		public Integer get(){
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e){
			}
			return 1;
		}
	}

	public static class PlusOne implements Function<Integer, Integer>{
		@Override
		public Integer apply(Integer x){
			return x + 1;
		}
	}


	public static void main(String[] args) throws Exception{
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		CompletableFuture<Integer> f = CompletableFuture.supplyAsync(new MySupplier(), executorService);
		System.out.println(f.isDone());
		CompletableFuture f2 = f.thenApply(new PlusOne());
		System.out.println(f2.get());


	}


}
