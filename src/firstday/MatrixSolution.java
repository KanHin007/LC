package firstday;

import java.util.Arrays;

/**
 * @author Lawrence Han
 * @date 2019.10.23
 * <p>
 * 矩阵的计算
 * <p>
 * 算法导论分治法例题
 */
public class MatrixSolution {


    /**
     * 暴力求解矩阵
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[][] calculateMatrixByViolence(int[][] arr1, int[][] arr2) {

        int length = arr1.length;

        int[][] resultArr = new int[length][length];

        // 三层for 循环计算
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    // 根据公式可得 a[i][j] = b[i][k] * c[k][j]
                    resultArr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return resultArr;
    }

    public static void main(String[] args) {

        int[][] arr1 = new int[][]{{1,2},{3,4}};
        int[][] arr2 = new int[][]{{3,4},{1,2}};

        int[][] result = calculateMatrixByViolence(arr1,arr2);

        for(int i = 0 ; i < result.length ; i++){
            System.out.println(Arrays.toString(result[i]));
        }

    }

}
