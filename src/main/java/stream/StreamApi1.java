package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream 的三个步骤
 * 1.创建Stream
 * 2.中间操作
 * 3.终止操作
 */
public class StreamApi1 {
    public void test1(){
        //1.可以通过Collection系列提供stream()串行流，或parallelStream并行流
        List<String>list=new ArrayList<>();
        Stream<String> stream1=list.stream();
        //2.通过Arrays的静态方法获取
        String[]str =new String[10];
        Stream<String>stream2= Arrays.stream(str);
        //3.通过Stream的静态方法of()
        Stream<String>stream3=Stream.of("aa","bb","cc");
        //4.创建无限流
            //迭代
        Stream<Integer>stream4=Stream.iterate(0,(x)->x+2);
        stream4.limit(10).forEach(System.out::println);
            //生成
        Stream.generate(()->Math.random()).limit(10).forEach(System.out::println);
    }
}
