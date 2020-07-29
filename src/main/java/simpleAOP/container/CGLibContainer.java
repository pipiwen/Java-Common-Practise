package simpleAOP.container;

import net.sf.cglib.proxy.Enhancer;
import simpleAOP.ProxyService.impl.ExceptionServiceProxy;
import simpleAOP.ProxyService.impl.LogServiceProxy;
import simpleAOP.annotation.Aspect;
import simpleAOP.interceptor.CGLibInterceptor;
import simpleAOP.persistent.InterceptPoint;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <Description> <br>
 * CGLibContailer 在初始化时会分析带有@Aspect注解的类,并分析出每个类在被调用前,后,异常时所需调用的方法
 * 在创建该类是如果有需要被调用的方法,则会创建出一个动态代理对象.
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/07/24 10:35 <br>
 * @see simpleAOP.container <br>
 */
public class CGLibContainer {
    //每个类的切点方法列表
    public static HashMap<Class<?>, Map<InterceptPoint, List<Method>>> interceptorMethodMap = new HashMap<>();

    //简化起见将需要扫描的带有@Aspect类,写死在代码中
    static Class<?>[]aspects = new Class<?>[] {
        LogServiceProxy.class,
                ExceptionServiceProxy.class
    };
    //加载容器时启动
    static {
        init();
    }
    /***
     * Description <br>
     * 分析带有@Aspect注解类,初始化interceptorMethodMap
     * @author shi.yuwen <br>
     * @createDate 2020/7/24 14:07 <br>
     * @param
     * @throws  <br>
     * @return void <br>
     **/
    public static void init () {
        for (Class<?> cls : aspects) {
            //检查是否带有@Aspect注解
            Aspect annotation = cls.getAnnotation(Aspect.class);
            if (null != annotation) {
                Method before = getMethod(cls,"before", new Class<?>[]{
                        Object.class, Method.class, Object[].class
                });
                Method after = getMethod(cls,"after", new Class<?>[]{
                        Object.class, Method.class, Object[].class, Object.class
                });
                Method exception = getMethod(cls,"exception", new Class<?>[]{
                        Object.class, Method.class, Object[].class, Throwable.class
                });
                //将before,after,exception加入目标类的切点方法列表中
                for (Class<?>interceptted : annotation.value()) {
                    addInterceptorMethod(interceptted, InterceptPoint.BEFORE, before);
                    addInterceptorMethod(interceptted, InterceptPoint.AFTER, after);
                    addInterceptorMethod(interceptted, InterceptPoint.EXCEPTION, exception);
                }
            }
        }

    }

    private static Method getMethod(Class<?> cls, String methodName, Class<?>[] paramType) {
        try {
            return cls.getMethod(methodName, paramType);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    /***
     * Description <br>
     * 将切点与所需执行的方法形成映射,对于带有@Aspect的cls可以查找对应的切点和切点方法
     * @author shi.yuwen <br>
     * @createDate 2020/7/24 10:52 <br>
     * @param cls
     * @param point
     * @param method <br>
     * @throws  <br>
     * @return void <br>
     **/
    private static void addInterceptorMethod(Class<?> cls, InterceptPoint point, Method method) {
        if (null == method) {
            return;
        }
        //获取类的的切点所对应的方法列表
        Map<InterceptPoint, List<Method>> interceptPointListMap = interceptorMethodMap.get(cls);
        if (null == interceptPointListMap) {
            interceptPointListMap = new HashMap<>();
            interceptorMethodMap.put(cls, interceptPointListMap);
        }
        List<Method> methods = interceptPointListMap.get(point);
        if (null == methods) {
            methods = new ArrayList<>();
            interceptPointListMap.put(point, methods);
        }
        methods.add(method);
    }

    /***
     * Description <br>
     *
     * @author shi.yuwen <br>
     * 创建CGLib代理
     **/
    public static <T>T createInstance(Class<T> cls) throws IllegalAccessException, InstantiationException {
        //判断是否需要代理
        if (!interceptorMethodMap.containsKey(cls)) {
            return (T) cls.newInstance();
        }
        //创建Enhancer类
        Enhancer enhancer = new Enhancer();
        //设置被代理对象
        enhancer.setSuperclass(cls);
        //设置被代理时执行方法调用
        enhancer.setCallback(new CGLibInterceptor());
        return (T) enhancer.create();
    }


}
