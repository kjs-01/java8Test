/**
 * Created by kjs850 on 2017. 2. 22..
 */
//LINK : http://www.journaldev.com/2752/java-8-interface-changes-static-method-default-method
public interface MyData {
    default void print(String str) {
        if (!isNull(str))
            System.out.println("MyData Print::" + str);
    }

    static boolean isNull(String str) {
        System.out.println("Interface Null Check");

        return str == null ? true : "".equals(str) ? true : false;
    }
}
