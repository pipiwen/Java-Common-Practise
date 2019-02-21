import lambda.Lambda2;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda2Test {
    @Test
    public void test1()throws Exception{
        Lambda2.happy(11111.11,(money)-> System.out.println("张三消费"+money+"￥"));
    }
    @Test
    public void test2()throws Exception{
    List <Integer>ramNum=Lambda2.getNum(10,()->(int) (Math.random()*100));
    for(int i:ramNum){
        System.out.println(i);
    }
    }
   @Test
    public void test3()throws Exception{
   String newStr= Lambda2.strHandler("\t\t\t测试function函数",(str)->str.trim());
       System.out.println(newStr);
    }
    @Test
    public void test4()throws Exception{
        List<String>list= Arrays.asList("hello","syw","world","ok");
           List<String> list1=Lambda2.filterStr(list,(s)->s.length()>3);
           for(String s:list1){
               System.out.println(s);
           }
    }
}
