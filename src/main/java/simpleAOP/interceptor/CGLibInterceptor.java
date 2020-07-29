package simpleAOP.interceptor;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import simpleAOP.container.CGLibContainer;
import simpleAOP.persistent.InterceptPoint;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <Description> <br>
 * CGLib动态代理对象
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/07/24 15:33 <br>
 * @see simpleAOP.interceptor <br>
 */
public class CGLibInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //先执行before方法
        List<Method> beforeMethods = getInterceptorMethods(o.getClass().getSuperclass(), InterceptPoint.BEFORE);
        for (Method m : beforeMethods) {
            m.invoke(null, new Object[]{o,method,args});
        }
        try {
            //调用原始方法
            Object result = methodProxy.invokeSuper(o, args);
            //执行after方法
            List<Method> afterMethods = getInterceptorMethods(o.getClass().getSuperclass(), InterceptPoint.AFTER);
            for (Method m : afterMethods) {
                m.invoke(null, new Object[]{o, method, args, result});
            }
            return result;
        }
        catch (Throwable e) {
            //执行Exception方法
            List<Method> expectionMethods = getInterceptorMethods(null, InterceptPoint.EXCEPTION);
            for (Method m : expectionMethods) {
                m.invoke(null, new Object[]{o, method, args, e});
            }
            throw e;
        }

    }

    private static List<Method> getInterceptorMethods (Class<?> cls, InterceptPoint point){
        Map<InterceptPoint, List<Method>> map = CGLibContainer.interceptorMethodMap.get(cls);
        if (null == map) {
            //返回一个静态的空的List避免占用内存
            return Collections.emptyList();
        }
        List<Method> methods = map.get(point);
        if (null == methods) {
            return Collections.emptyList();
        }
        return methods;
    }

}
