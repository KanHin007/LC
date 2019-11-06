package firstday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Lawrence Han
 * @date 2019.11.06
 * 三个数字之和
 */
public class ThreeSumSolution {


    /**
     * 利用暴力求解， 三层for循环
     * 超出限制并且也出现了重复解的问题
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        resultList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return resultList;
    }


    /**
     * 中心双指针法
     * 这里借鉴了网上的方法
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSumByCenterPoint(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return ans;
        }
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            } // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } // 去重
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    } // 去重
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    } // 去重
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0, 0, 0, 0}));
    }

}
