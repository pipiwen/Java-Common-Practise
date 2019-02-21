package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8 四大函数式接口
 *
 *1. Consumer<T>:消费型接口
 * void accept(T t);
 *
 *2.Supplier(T t):供给型接口
 *  T get();
 *
 *3.Function(T,R):函数型接口
 *  R apply(T t)
 *
 *4.Predicate<T>:断言型接口
 *   boolean test(T t);
 */
public class Lambda2 {
    public static void happy(Double money, Consumer<Double>consumer){
        consumer.accept(money);
    }
    //供给型接口产生制定个数的随机数
    public static List<Integer> getNum(Integer num, Supplier<Integer>supplier){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<num;i++){
            list.add(supplier.get());
        }
        return list;
    }
    //函数型接口
    public static String strHandler(String str, Function<String,String>fun){
        return fun.apply(str);
    }
    //将满足条件的字符串放入集合中
    public static List<String> filterStr(List<String>list, Predicate<String>pre){
        List<String> list1=new ArrayList<>();
        for(String s:list){
            if(pre.test(s)){
                list1.add(s);
            }
        }
        return list1;
    }
}
