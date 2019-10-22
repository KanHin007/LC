package firstday;

import java.util.Arrays;

/**
 * @author Lawrence Han
 * @date 2019.10.22
 * <p>
 * 题目描述
 * <p>
 * 1. 两个数字相加
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSumSolution {

    public static int[] twoSum(int[] nums, int target) {

        //外层循环每个元素
        for (int i = 0; i < nums.length - 1; i++) {
            //内部循环只循环外层循环的后一个
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[2];
    }

    public static void main(String[] args) {

        int[] paramArr = {2, 7, 11, 15};
        int target = 9;

        int[] resultArr = twoSum(paramArr, target);

        System.out.println("resultArr is " + Arrays.toString(resultArr));

    }


}
