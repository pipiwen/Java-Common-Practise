import org.junit.Test;
import singleton.Singleton1;

public class singletonTest {
    @Test
    public void test1()throws Exception{
        Singleton1 s1=Singleton1.getInstance();
        Singleton1 s2=Singleton1.getInstance();
        System.out.println(s1==s2);
    }
}
