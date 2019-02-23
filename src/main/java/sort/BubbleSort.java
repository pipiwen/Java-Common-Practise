package sort;

public class BubbleSort {
    public static void bubbleSort(int[] num){
        int temp=0;
        for(int i=0;i<num.length-1;i++){
            for(int j=0;j<num.length-i-1;j++){
                if(num[j]>num[j+1]){
                    temp=num[j+1];
                    num[j+1]=num[j];
                    num[j]=temp;
                }
            }
        }
        for(int n:num) {
            System.out.print(n+" ");
        }
    }
}
