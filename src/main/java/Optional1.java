import java.util.Optional;

/**
 * Created by kjs850 on 2017. 1. 31..
 */
//https://www.tutorialspoint.com/java8/java8_optional_class.htm
public class Optional1 {
    public static void main(String[] args) {
        Optional1 optional1 = new Optional1();
        Integer value1 = null;
        Integer value2 = new Integer(10);

        Optional<Integer> a = Optional.ofNullable(value1);
        Optional<Integer> b = Optional.of(value2);

        System.out.println(optional1.sum(a, b));

    }

    private Integer sum(Optional<Integer> a, Optional<Integer> b) {
        System.out.println("first param is present:" + a.isPresent());
        System.out.println("second param is present:" + b.isPresent());

        Integer value1 = a.orElse(new Integer(0));
        Integer value2 = b.get();

        return value1 + value2;
    }
}
