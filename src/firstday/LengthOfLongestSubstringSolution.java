package firstday;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author Lawrence Han
 * @date 2019.10.23
 * 无重复字符的最长子串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstringSolution {


    /**
     * 暴力求解
     * 时间复杂度会达到O(n3)
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        int maxLength = 0;

        // 针对与每个元素进行判断
        for (int i = 0; i < s.length(); i++) {

            int tempLength = 1;
            //获取后面的元素
            for (int j = i + 1; j < s.length(); j++) {
                String tempString = s.substring(i, j);
                // 构造字串 然后与后一个的元素进行contain判断
                if (s.charAt(i) != s.charAt(j) && !tempString.contains(s.subSequence(j, j + 1))) {
                    tempLength++;
                } else {
                    break;
                }
            }

            if (tempLength > maxLength) {
                maxLength = tempLength;
            }

        }

        return maxLength;

    }


    /**
     * 通过滑动窗口法 进行求解
     * 时间复杂度会达到O(n3)
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringBySlidingWindow(String s) {

        int maxLength = 0;
        HashSet<Character> sets = new HashSet<>();
        int size = s.length();
        int leftIndex = 0, rightIndex = 0;
        // 确定循环的条件
        while (leftIndex < size && rightIndex < size) {
            // 如果不包含下一个串 直接加进去 right的指针右移一位 left指针不动
            if (!sets.contains(s.charAt(rightIndex))) {
                sets.add(s.charAt(rightIndex++));
                maxLength = Math.max(maxLength, (rightIndex - leftIndex));
            } else {
                //如果包含的话 left指针右移一位 right 指针不懂
                sets.remove(s.charAt(leftIndex++));
            }
        }

        return maxLength;

    }


    public static void main(String[] args) {
        String testString = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(testString));
    }

}
