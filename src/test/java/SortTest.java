import org.junit.Test;
import sort.*;

public class SortTest {
    @Test
    public void test1()throws Exception{
        SwapSort.swapSort(3,6);
    }
    @Test
    public void test2()throws Exception{
        int []num={21,55,36,1,99,45,36,78,5};
        BubbleSort.bubbleSort(num);
    }
    @Test
    public void test3()throws Exception{
        int []num={21,55,36,1,99,45,36,78,5,61};
        SelectSort.selectSort(num);
    }
    @Test
    public void test4()throws Exception{
        int []num={21,55,36,1,99,45,36,78,6,61};
        InsertSort.insertSort(num);
    }
    @Test
    public void test5()throws Exception{
        int[] numbers = {10,20,15,0,6,7,2,1,-5,55,};
        System.out.print("排序前：");
        QuickSort.printArr(numbers);
        QuickSort.quick(numbers);
        System.out.print("快速排序后：");
        QuickSort.printArr(numbers);
    }
}
