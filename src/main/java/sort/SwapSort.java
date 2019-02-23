package sort;

public class SwapSort {
    public static void swapSort(int a,int b){
         a=a+b;
         b=a-b;
         a=a-b;
        System.out.println("a:"+a+" b:"+b);

    }
}
