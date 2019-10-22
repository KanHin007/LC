package firstday;

import java.util.Arrays;

/**
 * @author Lawrence Han
 * @date 2018.10.22
 * <p>
 * 插入排序
 * <p>
 * 算法导论里的例题 实现一下
 */
public class InsertionSortSolution {


    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            // 存储当前的index的数据，因为稍后会移动数组这个位置数据
            int temp = arr[i];
            int j = 0;
            // 向前遍历数据 , 每次用temp与前面的一个数据进行比较
            for (j = i - 1; j >= 0; j--) {
                // 如果当前的值大于要移动的数据 就讲当前的数据后以一位
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                }
            }
            // 将数据填补进空缺
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {

        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        insertionSort(arr);

        System.out.println(Arrays.toString(arr));


    }


}
