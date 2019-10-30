package firstday;

/**
 * @author Lawrence Han
 * @date 2019.10.23
 * <p>
 * 4. 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMedianSortedArraysSolution {


    /**
     * 将两个数据进行合并罗列 ， 然后求出中位数
     * 但是这里跟题目要求的log(m+n) 不符
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sumLength = nums1.length + nums2.length;
        int index = (nums1.length + nums2.length) / 2;
        int[] resultArr = new int[sumLength];

        boolean isOuShu = false;

        if (sumLength % 2 == 0) {
            index = index - 1;
            isOuShu = true;
        }

        int i = 0, j = 0, k = 0;

        for (; i < nums1.length && j < nums2.length; k++) {
            if (nums1[i] < nums2[j]) {
                resultArr[k] = nums1[i++];
            } else {
                resultArr[k] = nums2[j++];
            }

        }

        while (i < nums1.length) {
            resultArr[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            resultArr[k++] = nums2[j++];
        }


        if (!isOuShu) {
            return resultArr[index];
        } else {
            return (resultArr[index] + resultArr[index + 1]) / 2.0;
        }

    }


    public static void main(String[] args) {

    }

}
