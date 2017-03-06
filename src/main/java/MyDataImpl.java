/**
 * Created by kjs850 on 2017. 2. 22..
 */
public class MyDataImpl implements MyData{


    // static method는 @Override 할수 없다.
    public boolean isNull(String str) {
        System.out.println("Impl Null Check");

        return str == null ? true : false;
    }

    public static void main(String args[]){
        MyDataImpl obj = new MyDataImpl();
        obj.print("");
        obj.isNull("abc");
    }

}
