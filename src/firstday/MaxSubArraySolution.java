package firstday;

import java.util.Arrays;

/**
 * @author Lawrence Han
 * @date 2019.10.22
 * <p>
 * 最大子数组的问题
 * <p>
 * 算法导论的例题
 * <p>
 * 这里利用股票的场景模拟最大子数组
 */
public class MaxSubArraySolution {


    /**
     * 获取后一天的收益
     *
     * @param arr 当天价格列表
     * @return 获取每天的收益数组
     */
    public static int[] getIncomeArr(int[] arr) {

        int[] incomeArr = new int[arr.length - 1];
        for (int i = 0; i < incomeArr.length; i++) {
            incomeArr[i] = arr[i + 1] - arr[i];
        }
        return incomeArr;
    }


    /**
     * 通过暴力求解解出
     *
     * @param arr
     * @return
     */
    public static int[] getStartAndEndByViolence(int[] arr) {

        int[] resultArr = new int[2];

        int[] tempArr = getIncomeArr(arr);

        System.out.println(Arrays.toString(tempArr));

        // 临时变量存储maxSum
        int maxSum = 0;

        // 外层循环
        for (int i = 0; i < tempArr.length - 1; i++) {
            int sum = tempArr[i];
            // 内层循环 逐个相加
            for (int j = i + 1; j < tempArr.length; j++) {
                sum += tempArr[j];
                // 做比较
                if (sum > maxSum) {
                    maxSum = sum;
                    resultArr[0] = i;
                    resultArr[1] = j;
                }
            }
        }

        return resultArr;
    }


    /**
     * 通过分治法解决问题
     *
     * @return
     */
    public static int[] getStartAndEndByRecursion(int[] arr) {

        int[] incomeArr = getIncomeArr(arr);

        ArrayResult arrayResult = doRecursion(incomeArr, 0, incomeArr.length - 1);

        System.out.println(arrayResult);

        return new int[]{arrayResult.leftIndex, arrayResult.rightIndex};
    }

    /**
     * 递归主方法
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static ArrayResult doRecursion(int[] arr, int left, int right) {

        // 递归结束的条件
        if (left == right) {
            return new ArrayResult(left, right, arr[left]);
        } else {
            int mid = (left + right) / 2;

            if(left == 7 ){
                System.out.println("pause");
            }

            // 求出左边数组，右边数组，跨圈数组之和
            ArrayResult leftResult = doRecursion(arr, left, mid);
            ArrayResult rightResult = doRecursion(arr, mid + 1, right);
            ArrayResult crossResult = sumLeftArrAndRightArr(arr, left, mid, right);

            // 将三者进行比较得出结果
            if (leftResult.maxSum > rightResult.maxSum && leftResult.maxSum > crossResult.maxSum) {
                return leftResult;
            } else if (rightResult.maxSum > leftResult.maxSum && rightResult.maxSum > crossResult.maxSum) {
                return rightResult;
            } else {
                return crossResult;
            }

        }
    }

    /**
     * 跨两个数组进行求取数据之和
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @return
     */
    public static ArrayResult sumLeftArrAndRightArr(int[] arr, int left, int mid, int right) {

        int leftIndex = left, rightIndex = mid;
        int leftSum = 0, leftTempSum = 0, rightSum = 0, rightTempSum = 0;


        // 注意 ： 这里在编写的时候遇到了一个问题
        // 一定要是从中间向两边求和 不然结果会出问题

        // 左边数组求出最大和
        for (int i = mid; i >= left; i--) {
            leftTempSum += arr[i];
            if (leftTempSum > leftSum) {
                leftSum = leftTempSum;
                leftIndex = i;
            }
        }

        // 右边数组求出最大和
        for (int i = mid + 1; i <= right; i++) {
            rightTempSum += arr[i];
            if (rightTempSum > rightSum) {
                rightSum = rightTempSum;
                rightIndex = i;
            }
        }

        return new ArrayResult(leftIndex, rightIndex, leftSum + rightSum);
    }

    public static void main(String[] args) {

        /*int[] arr = {100, 20, 25, 36, 15};

        System.out.println(Arrays.toString(getIncomeArr(arr)));*/

        /*int[] arr = {100, 113, 110, 80, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};

        int[] resultArr = getStartAndEndByViolence(arr);

        System.out.println(Arrays.toString(resultArr));*/

        int[] arrTwo = {100, 113, 110, 80, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};

        int[] resultArrTwo = getStartAndEndByRecursion(arrTwo);

        System.out.println(Arrays.toString(resultArrTwo));

    }


    /**
     * 数组的数据结构， 因为分治法得出的结果要和上一个进行对比
     */
    static class ArrayResult {
        /**
         * 左边的索引
         */
        public int leftIndex;

        /**
         * 右边的索引
         */
        public int rightIndex;

        /**
         * 最大之和
         */
        public int maxSum;

        /**
         * 构造函数
         *
         * @param leftIndex
         * @param rightIndex
         * @param maxSum
         */
        public ArrayResult(int leftIndex, int rightIndex, int maxSum) {
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
            this.maxSum = maxSum;
        }

        @Override
        public String toString() {
            return "ArrayResult{" +
                    "leftIndex=" + leftIndex +
                    ", rightIndex=" + rightIndex +
                    ", maxSum=" + maxSum +
                    '}';
        }
    }
}


