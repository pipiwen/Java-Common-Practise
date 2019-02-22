import lambda.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * filter-接收lambda,从流中排除某些元素
 * limit-截断流,使流不超过某些元素
 * skip-跳过元素，返回一个扔掉了n个元素的流，若元素不足n个,返回一个空流,与limit互补
 * distinct-筛选,通过流生成元素的hashcode()和equals()去除重复元素,需要重写hashcode()，equals()方法
 */
public class StreamApiTest {
    private List<Employee> empList= Arrays.asList(
            new Employee(101,"张三",21,9999.99),
            new Employee(102,"李四",22,4449.99),
            new Employee(103,"王五",23,7779.99),
            new Employee(104,"张柳",22,6666.66),
            new Employee(104,"张柳",22,6666.66),
            new Employee(105,"朱八",25,5555.55));

    @Test
    public void test1()throws Exception{
        empList.stream()
                .filter((e)->e.getAge()>21)
                .limit(3)
                .forEach(System.out::println);//终止操作，否则不打印
    }
    //外部迭代
    @Test
    public void test2()throws Exception{
    Iterator<Employee>it=empList.iterator();
    while (it.hasNext()){
        System.out.println(it.next());
    }
    }
    @Test
    public void test3()throws Exception{
    empList.stream()
            .filter((e)->e.getSalary()>6000.00)
            .skip(1)
            .distinct()
            .forEach(System.out::println);
    }

    /**
     *
     * 使用map操作所有元素
     * add(Obj),addAll(Collection coll):第一个将整个集合作为整体添加，第二个将集合中所有元素添加-
     *
     */
    @Test
    public void test4()throws Exception{
        List<String>strList=Arrays.asList("aaa","bbb","ccc","ddd");
        strList.stream()
                .map((s)->s.toUpperCase())
                .forEach(System.out::println);
}
    @Test
    public void test5()throws Exception{
    empList.stream()
            .map((e)->e.getName())
            .forEach(System.out::println);
    }
    @Test
    public void test6()throws Exception{
        List<String>strList=Arrays.asList("aaa","bbb","ccc","ddd");
        Stream<Stream<Character>>charStream= strList.stream()
                .map(StreamApiTest::filterCharacter);
        charStream.forEach((stream)->{
            stream.forEach(System.out::println);
        });
    }
    public static Stream<Character>filterCharacter(String str){
        List<Character>charList=new ArrayList<>();
        for (Character c: str.toCharArray()) {
            charList.add(c);
        }
        return charList.stream();
    }
    /**
     * 自然排序:(comparable compare to())
     * 定制排序:(comparator)
     */
    @Test
    public void test7()throws Exception{
    empList.stream()
            .sorted((e1,e2)->{
                if(e1.getAge()==e2.getAge()){
                    return e1.getName().compareTo(e2.getName());
                }else {
                    return Integer.compare(e1.getAge(),e2.getAge());
                }
            })
            .forEach(System.out::println);
    }
    //获取工资最高的员工
    @Test
    public void test8()throws Exception{
    Optional<Employee>op =empList.stream()
            .max((e1,e2)-> Double.compare(e1.getSalary(),e2.getSalary()));
        System.out.println(op.get());
    }
    //计算所有员工工资总和
    @Test
    public void test9()throws Exception{
    Optional<Double>op=empList.stream()
            .map(Employee::getSalary)
            .reduce(Double::sum);
        System.out.println(op.get());
    }
}
