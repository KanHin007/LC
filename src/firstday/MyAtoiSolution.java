package firstday;

/**
 * @author Neo Kuang
 * @date 2019.10.31
 * 字符串转化为数字
 * <p>
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyAtoiSolution {


    /**
     * 字符串转化数字的方法
     * todo 这里逻辑的坑是在太多 注意吧
     * @param str
     * @return
     */
    public static int myAtoi(String str) {

        boolean firstBlank = true;
        boolean firstFuHao = true;
        long result = 0L;
        long chengShu = 1;
        // 循环遍历字符串
        for (int i = 0; i < str.length(); i++) {
            //遇到空格直接跳过
            if (firstFuHao && str.charAt(i) == ' ') {
                if (firstBlank) {
                    continue;
                } else {
                    break;
                }
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                firstBlank = false;
                firstFuHao = false;
                result = result * 10L + (long) (str.charAt(i) - 48);
                if (chengShu * result > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;

                } else if (chengShu * result < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;

                }
            } else if (str.charAt(i) == '-') {
                if (firstFuHao) {
                    chengShu = -1;
                    firstFuHao = false;
                } else {
                    break;
                }
            } else if (str.charAt(i) == '+') {
                if (firstFuHao) {
                    firstFuHao = false;
                } else {
                    break;
                }
            } else {
                // 如果遇到其他的字符串直接跳出循环
                break;
            }
        }
        result = chengShu * result;
        if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }

        return (int) result;
    }


    public static void main(String[] args) {
        /*System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("  0000000000012345678"));*/
        System.out.println(myAtoi("-   234"));
    }

}
