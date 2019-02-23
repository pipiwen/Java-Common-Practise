package sort;

public class InsertSort {
    public static void insertSort(int[] num){
        int temp=0;
        int j=0;
        for(int i=0;i<num.length;i++){
            temp=num[i];
            for( j=i;j>0&&temp<num[j-1];j--){
                num[j]=num[j-1];
            }
            num[j]=temp;
        }
        for(int n:num) {
            System.out.print(n+" ");
        }
    }
}
