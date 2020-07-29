package simpleAOP.ProxyService.impl;

import com.sun.org.apache.xpath.internal.objects.XObject;
import simpleAOP.ProxyService.LogAspect;
import simpleAOP.annotation.Aspect;
import simpleAOP.service.ServiceA;
import simpleAOP.service.ServiceB;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/07/23 19:47 <br>
 * @see simpleAOP <br>
 */
@Aspect({ServiceA.class, ServiceB.class})
public class LogServiceProxy {
    /*private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void before(Object obj, Method method, Object[] args) {
        System.out.println(formatter.format(LocalDateTime.now()) + "Entering " + method.getDeclaringClass().getName() +
                method.getName() + " args: " + Arrays.toString(args));
    }

    @Override
    public void after(Object obj, Method method, Object[] args, Object result) {
        System.out.println(formatter.format(LocalDateTime.now()) + "Leaving " + method.getDeclaringClass().getName() +
                method.getName() + " result: " + result);
    }*/


        public static void before(Object object, Method method, Object[] args) {
            System.out.println("entering " + method.getDeclaringClass().getSimpleName()
                    + "::" + method.getName() + ", args: " + Arrays.toString(args));
        }

        public static void after(Object object, Method method, Object[] args, Object result) {
            System.out.println("leaving " + method.getDeclaringClass().getSimpleName()
                    + "::" + method.getName() + ", result: " + result);
        }


}
