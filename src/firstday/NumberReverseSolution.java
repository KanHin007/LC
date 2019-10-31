package firstday;

/**
 * @author Lawrence Han
 * @date 2019.10.31
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberReverseSolution {


    /**
     * 反转字符串 不断相除得到数字位置 进行合并
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        StringBuilder resultSb = new StringBuilder();
        // 判断数字的性质 是否是正数还是负数
        int positive = 1;
        long temp = x;
        if (x < 0) {
            positive = -1;
            temp = -1L * x;
        }

        while (temp > 0) {
            resultSb.append(temp % 10);
            temp = temp / 10;
        }
        int index = 0;
        while (index < resultSb.length() && resultSb.charAt(index) == '0') {
            resultSb.deleteCharAt(index);
        }
        long result = Long.valueOf(resultSb.toString());
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }

        return positive * (int) result;
    }


    /**
     * 直接利用列项的时候 将结果加上去
     * todo 这里是看到别人的解法
     *
     * @param x
     * @return
     */
    public static int reverseBySimple(int x) {
        if (x == 0) {
            return 0;
        }

        long result = 0;
        while (x != 0) {
            int s = x % 10;
            x = x / 10;
            result = result * 10 + s;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }


    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(120));
        System.out.println(reverse(-120));
        System.out.println(reverseBySimple(901000));
    }

}
