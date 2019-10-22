package firstday;

import java.util.Arrays;

/**
 * @author Lawrence Han
 * @date 2018.10.22
 * <p>
 * 归并排序
 * <p>
 * 算法导论中的例题
 */
public class MergeSortSolution {


    /**
     * 归并排序主方法体
     *
     * @param arr  目标数组
     * @param low  左边的索引
     * @param high 右边的索引
     */
    public static void mergeSort(int[] arr, int low, int high) {

        // 递归的条件判断
        if (low < high) {
            // 获取中值
            int mid = (high + low) / 2;
            // 进行左边递归
            mergeSort(arr, low, mid);
            // 进行右边递归
            mergeSort(arr, mid + 1, high);
            // 两边数组的数据进行合并
            merge(arr, low, mid, high);
        }

    }

    /**
     * 归并排序的内部实现方法
     *
     * @param arr
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int[] arr, int low, int mid, int high) {

        // 首先单独初始化做数组和右数组
        int[] leftArr = new int[mid - low + 1];
        int[] rightArr = new int[high - mid];

        //给两个数组进行赋值
        for (int i = low; i <= mid; i++) {
            leftArr[i - low] = arr[i];
        }
        for (int i = mid + 1; i <= high; i++) {
            rightArr[i - mid - 1] = arr[i];
        }

        int i = 0;
        int j = 0;
        int k = 0;
        // 这一步进行遍历，然后对两个数组进行真正的归并操作
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) {
                arr[low + k] = leftArr[i];
                i++;
                k++;
            } else {
                arr[low + k] = rightArr[j];
                j++;
                k++;
            }
        }


        //这里在编写的时候除了很大的问题 没有对原数组的下标进行处理导致复赋值出现了错误
        while (i < leftArr.length) {
            arr[low + (k++)] = leftArr[i++];
        }

        while (j < rightArr.length) {
            arr[low + (k++)] = rightArr[j++];
        }


    }

    public static void main(String[] args) {

        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

        /*int[] arr = {1,3,5,7,9,11,2,4,6,8,10,12};

        merge(arr,0,5,11);

        System.out.println(Arrays.toString(arr));*/

    }


}
