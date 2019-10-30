package firstday;

/**
 * @author Lawrence Han
 * @date 2019.10.30
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindromeSolution {


    /**
     * 暴力破解
     * todo 注意这里leetcode超时了
     *
     * @param s
     * @return
     */
    public static String longestPalindromeByBaoLi(String s) {
        int max = 0;
        String resultStr = "";

        // 这里构造了每一种字串的可能性，然后调用反转函数进行判断
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                StringBuilder sb = new StringBuilder(s.substring(i, j));
                if (sb.toString().equals(sb.reverse().toString())) {
                    if (max < sb.length()) {
                        max = sb.length();
                        resultStr = sb.toString();
                    }
                }
            }
        }
        return resultStr;
    }

    /**
     * 利用反转后的字符串求公共字串
     * todo 也超出了时间限制
     *
     * @param s
     * @return
     */
    public static String longestPalindromeByReverseStr(String s) {
        int length = 0;
        String resultStr = "";
        StringBuilder sb = new StringBuilder(s);
        String reverseStr = sb.reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                int k = i;
                int l = j;
                StringBuilder sbTemp = new StringBuilder();
                // 如果两个字母相同
                while (k < s.length() && l < s.length()) {
                    if (s.charAt(k) == reverseStr.charAt(l)) {
                        sbTemp.append(s.charAt(k));
                        k++;
                        l++;
                    } else {
                        k = i;
                        l++;
                        sbTemp = new StringBuilder();
                    }

                    String a = sbTemp.toString();
                    String b = sbTemp.reverse().toString();
                    sbTemp.reverse();
                    if (a.equals(b) && sbTemp.length() > length) {
                        length = sbTemp.length();
                        resultStr = sbTemp.toString();
                    }

                }

            }
        }

        return resultStr;
    }


    /**
     * 利用动态规划 求出结果
     * <p>
     * 构造二维数组
     * todo 这个是动态规划的典型例题 一定要反复的学习
     *
     * @param s
     * @return
     */
    public static String longestPalindromeNormal(String s) {

        //记录开始和结束
        int start = 0;
        int end = 0;
        int maxLen = 0;
        int length = s.length();
        int[][] p = new int[length][length];

        maxLen = 1;
        // 初始化数组 将每个位置上i==j都初始化成1 或者将相邻的两个相同的元素初始化成1
        for (int i = 0; i < length; i++) {
            p[i][i] = 1;
            if (i <= length - 2 && s.charAt(i) == s.charAt(i + 1)) {
                start = i;
                p[i][i + 1] = 1;
                maxLen = 2;
            }
        }

        // 设定长度从3开始
        for (int l = 3; l <= length; l++) {
            for (int i = 0; i + l - 1 < length; i++) {
                // 结束的未知
                int j = l + i - 1;
                if (p[i + 1][j - 1] == 1 && s.charAt(i) == s.charAt(j)) {
                    p[i][j] = 1;
                    start = i;
                    maxLen = l;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    /**
     * 中心扩散法 这里没有直接实现
     * todo 直接搬运过来 需要理解
     *
     * @param s
     * @return
     */
    public static String longestPalindromeCentralChange(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    public static void main(String[] args) {

        String str = "cbbd";
        String str1 = "aacfedcaa";
        String str3 = "babad";
        System.out.println(longestPalindromeCentralChange(str3));

    }


}
