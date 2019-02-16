package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyInInvocationHandler implements InvocationHandler {
    private Object obj;
    public Object blind(Object obj){
        this.obj=obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);//返回代理对象
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("开始时间:"+sdf.format(new Date())+" 当前方法:"+method.getName());
        Object result=method.invoke(obj,args);
        return result;
    }
}
