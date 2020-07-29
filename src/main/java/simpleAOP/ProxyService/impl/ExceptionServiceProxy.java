package simpleAOP.ProxyService.impl;

import simpleAOP.ProxyService.ExceptionAspect;
import simpleAOP.annotation.Aspect;
import simpleAOP.service.ServiceA;
import simpleAOP.service.ServiceB;

import java.lang.reflect.Method;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/07/23 19:51 <br>
 * @see simpleAOP.ProxyService.impl <br>
 */
@Aspect({ServiceB.class})
public class ExceptionServiceProxy {
    /*private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Override
    public void exception(Object obj, Method method, Object[] args, Throwable e) {
        System.err.println("exception when calling: " + method.getName()
                + "," + Arrays.toString(args));
    }*/
    public static void exception(Object object,
                                 Method method, Object[] args, Throwable e) {
        System.err.println("exception when calling: " + method.getName()
                + "," + Arrays.toString(args));
    }
}
