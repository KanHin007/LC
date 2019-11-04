package firstday;

/**
 * @author Lawrence Han
 * @date 2019.11.04
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxAreaSolution {


    /**
     * 求盛水的最大面积
     * 最简单的暴力求解
     * o(n2)肯定是不行的
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;

        // 两层for循环解决问题
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                // 最小的那根 * 两根之间的间隔
                int minLen = Math.min(height[i], height[j]);
                int tempArea = minLen * (j - i);
                if (maxArea < tempArea) {
                    maxArea = tempArea;
                }
            }
        }

        return maxArea;
    }


    /**
     * 求盛水的最大面积
     * 双指针同时向中间移动
     *
     * @param height
     * @return
     */
    public static int maxAreaFast(int[] height) {
        int maxArea = 0;
        int leftCursor = 0;
        int rightCursor = height.length - 1;

        // 两个指针同时向中间移动
        while (leftCursor != rightCursor) {
            int temp = Math.min(height[leftCursor], height[rightCursor]) * (rightCursor - leftCursor);
            if (temp > maxArea) {
                maxArea = temp;
            }
            if (height[leftCursor] < height[rightCursor]) {
                leftCursor++;
            } else {
                rightCursor--;
            }
        }
        return maxArea;

    }


}
