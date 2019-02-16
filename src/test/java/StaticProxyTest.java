import org.junit.Test;
import staticproxy.Person;
import staticproxy.PersonProxy;

public class StaticProxyTest {
    @Test
    public void test1()throws Exception{
        PersonProxy personProxy=new PersonProxy(new Person());
        personProxy.eat();
        personProxy.sleep();
    }
}
