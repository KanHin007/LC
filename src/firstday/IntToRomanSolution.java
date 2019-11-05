package firstday;

/**
 * @author Lawrence Han
 * @date 2019.11.05
 * <p>
 * 数字转换成罗马数字
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 * <p>
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntToRomanSolution {


    /**
     * 先分解每个位置，然后拼接
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        StringBuilder sbResult = new StringBuilder();
        int substact = num;
        int weiShu = 1;
        while (substact > 0) {
            // 得出余数
            int yuShu = substact % 10;
            substact = substact / 10;
            StringBuilder sb = new StringBuilder();
            if (weiShu == 1) {
                if (yuShu == 9) {
                    yuShu -= 9;
                    sb.insert(0, "IX");
                } else if (yuShu >= 4) {
                    if (yuShu == 4) {
                        yuShu -= 4;
                        sb.insert(0, "IV");
                    } else {
                        sb.insert(0, "V");
                        yuShu -= 5;
                    }
                }
                while (yuShu > 0) {
                    sb.append("I");
                    yuShu--;
                }
            } else if (weiShu == 2) {
                if (yuShu == 9) {
                    yuShu -= 9;
                    sb.insert(0, "XC");
                } else if (yuShu >= 4) {
                    if (yuShu == 4) {
                        yuShu -= 4;
                        sb.insert(0, "XL");
                    } else {
                        sb.append("L");
                        yuShu -= 5;
                    }
                }
                while (yuShu > 0) {
                    sb.append("X");
                    yuShu--;
                }
            } else if (weiShu == 3) {
                if (yuShu == 9) {
                    yuShu -= 9;
                    sb.insert(0, "CM");
                } else if (yuShu >= 4) {
                    if (yuShu == 4) {
                        yuShu -= 4;
                        sb.insert(0, "CD");
                    } else {
                        sb.insert(0, "D");
                        yuShu -= 5;
                    }
                }
                while (yuShu > 0) {
                    sb.append("C");
                    yuShu--;
                }
            } else if (weiShu == 4) {
                while (yuShu > 0) {
                    sb.insert(0, "M");
                    yuShu--;
                }
            }

            weiShu++;
            sbResult.insert(0, sb);
        }


        return sbResult.toString();
    }


    /**
     * 利用贪心算法解决这个问题
     *
     * @param num
     * @return
     */
    public static String intToRomanByGreed(int num) {
        StringBuilder sb = new StringBuilder();
        // 初始化数组
        String[] strArr = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] numArr = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int subtract = num;
        for (int i = 0; i < strArr.length; ) {
            if (numArr[i] <= subtract) {
                subtract -= numArr[i];
                sb.append(strArr[i]);
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRomanByGreed(1994));
    }


}
