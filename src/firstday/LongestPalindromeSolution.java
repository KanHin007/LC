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
                    if (a.equals(b) && sbTemp.length() > length ) {
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
     *
     * @param s
     * @return
     */
    public static String longestPalindromeNormal(String s) {


        return null;
    }

    public static void main(String[] args) {

        String str = "aacdefcaa";
        String str1 = "aacfedcaa";
        System.out.println(longestPalindromeByReverseStr(str));

    }


}
