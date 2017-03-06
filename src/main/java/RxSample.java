import rx.Observable;
import rx.Subscriber;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kjs850 on 2017. 2. 20..
 */
public class RxSample {

    public static void main(String[] args) {


        Observable<String> howdy =  Observable.just("Howdy!");
        howdy.subscribe(System.out::println);

        Observable.just("Hello", "World")
                .subscribe(System.out::println);

        List<String> words = Arrays.asList(
                "the",
                "quick",
                "brown",
                "fox",
                "jumped",
                "over",
                "the",
                "lazy",
                "dog"
        );

        Observable.just(words)
                .subscribe(System.out::println);

        //Observable.range(1, 5).subscribe(System.out::println);

        //rxJava
        Observable<Integer> source = Observable.range(1, 5); // source of data
        Subscriber<Integer> consumer = new Subscriber<Integer>() { // Consumer of data
            public void onCompleted() {
                System.out.println("completed");
            }

            public void onError(Throwable throwable) {
                System.out.println(throwable.getStackTrace());
            }

            public void onNext(Integer number) {
                System.out.println(number);
            }
        };
        source.subscribe(consumer); // Connecting Consumer to Source

        // A concise version of above code written using Java 8
        source.subscribe(
                number -> System.out.println("concise:" + number)
//                error -> System.out.println("error"),
//                () -> System.out.println("completed")
        );

        // Note that below code is not optimal but it helps in demonstration of concepts
        // A better version is shown in the next section
        Observable.create(new Observable.OnSubscribe<String>() { // The Action
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    // Events are pushed to the subscriber -
                    String result = "doSomeTimeTakingIoOperation();" ;
                    subscriber.onNext(result);    // Pass on the data to subscriber
                    subscriber.onCompleted();     // Signal about the completion subscriber
                } catch (Exception e) {
                    subscriber.onError(e);        // Signal about the error to subscriber
                }
            }
        });
    }



}
