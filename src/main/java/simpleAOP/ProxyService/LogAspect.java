package simpleAOP.ProxyService;

import java.lang.reflect.Method;

public interface LogAspect {
    void before(Object obj, Method method, Object[] args);


    void after(Object obj, Method method, Object[] args, Object result);

}
