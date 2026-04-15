public class MyTestUtils {
    public static  int Add(int a,int b) {
        return a + b;
    }
    public static <T extends Number> T Add(T a,T b){
        if(((Integer) a) != null){
            return  T.cast(a.intValue() + b.intValue());
        }
        else{
            return T.cast(0);
        }
    }
}
