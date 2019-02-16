import dynamicproxy.AdidasFactory;
import dynamicproxy.ClothFactory;
import dynamicproxy.MyInInvocationHandler;
import dynamicproxy.NikeFactory;
import org.junit.Test;

public class DynamicProxy {
    @Test
    public void test1()throws Exception{
        MyInInvocationHandler handler=new MyInInvocationHandler();
        Object obj1=handler.blind(new NikeFactory());
        ClothFactory clothFactory=(ClothFactory)obj1;
        clothFactory.makeClothes();
    }
    @Test
    public void test2()throws Exception{
        MyInInvocationHandler handler=new MyInInvocationHandler();
        ClothFactory clothFactory=(ClothFactory)handler.blind(new AdidasFactory());
        clothFactory.makeClothes();
    }
}
