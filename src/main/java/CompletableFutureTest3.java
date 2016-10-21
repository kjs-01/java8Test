import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by kjs850 on 2016. 10. 18..
 */
public class CompletableFutureTest3 {

	//http://www.concretepage.com/java/jdk-8/java-8-completablefuture-example

	public static void main(String[] args) throws Exception{

//		List<Integer> list = Arrays.asList(10,20,30,40);
//		list.stream().map(data -> CompletableFuture.supplyAsync(() -> getNumber(data)))
//				.map(compFuture -> compFuture.thenApply(n -> n * n))
//				.map(t -> t.join())
//				.forEach(s -> System.out.println(s));
		List<String> list = Arrays.asList("A", "B", "C", "D");
		int count = (int) list.stream().map(data-> CompletableFuture.supplyAsync(() -> "Processing:" + data)).
				map(compFuture->compFuture.thenAccept(s->System.out.println(s))).map(t->t.join())
				.count();
		System.out.println(count);


	}

	private static int getNumber(int a) {
		return a * a;
	}

}
