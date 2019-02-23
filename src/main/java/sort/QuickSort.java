package sort;

public class QuickSort {
    public static int getMiddle(int[] numbers,int low,int high){
        int temp=numbers[low];
        while (low<high){
            while(low<high &&numbers[high]>temp){
                high--;
            }
            numbers[low]=numbers[high];
            while (low<high &&numbers[low]<temp){
                low++;
            }
            numbers[high]=numbers[low];
        }
        numbers[low]=temp;
        return low;
    }
    //递归形式分治算法
    public static void quickSort(int[] numbers,int low,int high)
    {
        if(low < high)
        {
        int middle = getMiddle(numbers,low,high); //将numbers数组进行一分为二
        quickSort(numbers, low, middle-1);   //对低字段表进行递归排序
        quickSort(numbers, middle+1, high); //对高字段表进行递归排序
        }

    }
    public static void quick(int[] numbers)
    {
        if(numbers.length > 0)   //查看数组是否为空
        {
            quickSort(numbers, 0, numbers.length-1);
        }
    }
    public static void printArr(int[] numbers)
    {
        for(int i = 0 ; i < numbers.length ; i ++ )
        {
            System.out.print(numbers[i] + ",");
        }
        System.out.println("");
    }
}
