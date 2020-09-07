package sort;

import java.util.Arrays;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/08/31 19:33 <br>
 * @see sort <br>
 */
public class QuickSortPractise {
    public static int quickSort(int[] number, int low, int high) {
        int temp = number[low];
        while (low < high) {
            while (low < high && number[high] > temp) {
                high--;
            }
            number[low] = number[high];
            while (low < high && number[low] < temp) {
                low++;
            }
            number[high] = number[low];
        }
        number[low] = temp;
        return low;
    }
    public static void statQuickSort(int[] number, int low, int high) {
        if (low < high) {
            int middle = quickSort(number, low, high);
            statQuickSort(number, low, middle - 1);
            statQuickSort(number, middle + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] num = {89,101,63,44,-8,66,-17,74,1};
        statQuickSort(num, 0, num.length-1);
        System.out.println("排序后: " + Arrays.toString(num));
    }
}
