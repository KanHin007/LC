package firstday;

/**
 * @author Lawrence Han
 * @date 2019.10.31
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindromeSolution {


    /**
     * 判断数字是不是回文数字 当前解法 直接将数字变成字符串 然后反转进行比较
     *
     *  todo 还有一种类似的解法就是将 字符串一半与一半进行对比
     *
     * @param numbers
     * @return
     */
    public static boolean isPalindrome(int numbers) {
        String str = String.valueOf(numbers);
        StringBuilder stringBuilder = new StringBuilder(str);
        return stringBuilder.toString().equals(stringBuilder.reverse().toString());
    }


    /**
     * 判断数字是不是回文数字 不用字符串做媒介
     * 直接用 反转后的数字与愿数字进行比较是否相等
     *
     * @param x
     * @return
     */
    public static boolean isPalindromeWithoutStr(int x) {

        int s = 0;
        int x1 = x;
        while (x1 > 0) {
            s = s * 10 + x1 % 10;
            x1 = x1 / 10;
        }
        return s == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
    }

}
