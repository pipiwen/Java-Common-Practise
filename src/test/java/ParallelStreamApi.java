import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

/**
 * java8并行流
 */
public class ParallelStreamApi {
    //使用单线程
    @Test
    public void  test1()throws Exception{
        long sum=0;
        Instant start=Instant.now();
        for(long i=1;i<=100000000000L;i++){
            sum+=i;
        }
        Instant end=Instant.now();
        System.out.println(sum);
        System.out.println("消耗时间："+ Duration.between(start,end).toMillis());
    }
    //使用java8并行流(多线程)
    @Test
    public void test2()throws Exception{
        Instant start=Instant.now();
        Long result=LongStream.rangeClosed(0,100000000000L)
                .parallel()//启用并行流
                .reduce(0,Long::sum);
        Instant end=Instant.now();
        System.out.println(result);
        System.out.println("并行流消耗时间:"+Duration.between(start,end).toMillis());
    }
}
