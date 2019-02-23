package sort;

/**
 * 二分查找实现
 * @param arr 有序数组
 * @param key 待查找关键字
 * @return 找到的位置
 */
public class BinarySearch {
    public static int binarySearch(int []arr,int key,int low,int high){
        if(key<arr[low]||key>arr[high]||low>high){
            return -1;
        }
        int middle=(low+high)/2;
        if(key<arr[middle]){
            return binarySearch(arr,key,low,middle-1);
        }else if(key>arr[middle]){
            return binarySearch(arr,key,middle+1,high);
        }else {
            return middle;
        }
    }
}
