package sort;

public class SelectSort {
    public static void selectSort(int[] num){
        int temp=0;
        for(int i=0;i<num.length;i++){
            int k=i;
            for(int j=num.length-1;j>i;j--){
                if(num[j]<num[k]){
                    k=j;
                }
            }
            temp=num[i];
            num[i]=num[k];
            num[k]=temp;
        }
        for(int n:num) {
            System.out.print(n+" ");
        }
    }
}
