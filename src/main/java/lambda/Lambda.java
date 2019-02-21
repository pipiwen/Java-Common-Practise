package lambda;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Java8新特性Lambda表达式
 */
public class Lambda {
    //无参数，无返回值(对比内部类)
    public static void test1(){
        Runnable r1=new Runnable() {
            public void run() {
                System.out.println("hello World:r1");
            }
        };
        r1.run();
        System.out.println("--------------------------");

        Runnable r2 =()-> System.out.println("hello World:r2");
        r2.run();
    }
    //有一个参数，无返回值
    public static void test2(){
        Consumer<String> consumer=(x)-> System.out.println(x);
            consumer.accept("Consumer的Lambda实现");
    }
    //有多个参数，有返回值，Lambda体中有多条语句
    public static  void test3(){
        Comparator<Integer>comparator=(o1,o2)->{
            System.out.println("执行comparator比较");
            System.out.println(Integer.compare(o1,o2));
            return Integer.compare(o1,o2);
        };
        comparator.compare(1,3);
    }
}
