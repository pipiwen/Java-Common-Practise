package simpleAOP.ProxyService;

import java.lang.reflect.Method;

public interface ExceptionAspect {
    void exception (Object obj, Method method, Object[] args, Throwable e);
}
