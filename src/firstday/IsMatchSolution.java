package firstday;

/**
 * @author Lawrence Han
 * @date 2019.11.01
 * 正则匹配字符串
 * <p>
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * todo 这个题有点难度 借鉴一下官方的题解
 */
public class IsMatchSolution {

    /**
     * 回朔法
     * <p>
     * 目标字符串是否与正则字符串进行匹配
     * <p>
     * 如果模式串中有星号，它会出现在第二个位置，即 \text{pattern[1]}pattern[1] 。
     * 这种情况下，我们可以直接忽略模式串中这一部分，或者删除匹配串的第一个字符，
     * 前提是它能够匹配模式串当前位置字符，即 \text{pattern[0]}pattern[0] 。
     * 如果两种操作中有任何一种使得剩下的字符串能匹配，那么初始时，匹配串和模式串就可以被匹配。
     *
     * @param str
     * @param regex
     * @return
     */
    public static boolean isMatch(String str, String regex) {

        // 这里的思路就是 先尝试解决非匹配模式的情况
        // 也就是排除掉第一个if的情况 循环解决两个字符串的第一个字母进行匹配

        if (regex.isEmpty()) {
            return str.isEmpty();
        }

        boolean firstMatch = false;
        firstMatch = !str.isEmpty() && (str.charAt(0) == str.charAt(0) || regex.charAt(0) == '.');

        // 这里的if就是解决的核心
        // 如果遇到了第二个字母为幸星号的情况 ，
        // 先去掉星号匹配（这里是因为 不是第一次 是为了递归而准备的） 然后进行消减第一字符进行匹配
        if (regex.length() >= 2 && regex.charAt(1) == '*') {
            return isMatch(str, regex.substring(2)) || (firstMatch && isMatch(str.substring(1), regex));
        } else {// 利用递归判断符不符合条件
            return firstMatch && isMatch(str.substring(1), regex.substring(1));
        }
    }

    /**
     * 利用动态规划解决问题
     *
     * @param text
     * @param pattern
     * @return
     */
    public static boolean isMatchByDp(String text, String pattern) {
        // 动态规划二维数组存储状态
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        // 双层便利 匹配出两个字符串索引的组合情况
        // 从后往前推
        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean firstMatch = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                // 这里跟回朔法很相似
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j];
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {

        String str = "aaaa";
        String regex = "a*";

        System.out.println(isMatch(str, regex));

    }

}
