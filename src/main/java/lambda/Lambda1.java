package lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lambda1 {
    private static List<Employee> empList= Arrays.asList(
            new Employee(101,"张三",21,9999.99),
            new Employee(102,"李四",22,4449.99),
            new Employee(103,"王五",23,7779.99),
            new Employee(104,"张柳",22,6666.66),
            new Employee(105,"朱八",25,5555.55));

    /**
     * 使用Lambda表达式
     * 先比较年龄相同的按姓名比较
     */
    public static void test1(){
        Collections.sort(empList,(e1, e2)->{
            if(e1.getAge()==e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        for(Employee emp:empList){
            System.out.println(emp);
        }
    }
    public static void test2(){
        String strTrim=strHandler("\t\t待处理字符串",(str)-> str.trim());
        System.out.println(strTrim);
        String strUp=strHandler("abcdef",(str)->{str.toUpperCase();
                                                    System.out.println(str.toUpperCase());
                                                    return str.toUpperCase();});
    }
    //处理字符串
    public static String strHandler(String str,MyFunction mf){
        return mf.getValue(str);
    }

    //对于两个long值进行处理
    public static Long longHandler(long l1,long l2, MyFunction2<Long,Long> mf){
        return (long)mf.getValue(l1,l2);
    }
    public static void test3(){
        Long result=longHandler(100L,200L,(l1,l2)->l1+l2);
        System.out.println(result);
    }
}
