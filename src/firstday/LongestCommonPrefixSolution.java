package firstday;

/**
 * @author Lawrence Han
 * @date 2019.11.05
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefixSolution {


    /**
     * 直接暴力求解
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        String str = strs[0];
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            String tempStr = str.substring(0, i);
            boolean ok = true;
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(tempStr)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                result = tempStr;
            }
        }
        return result;
    }


    /**
     * 利用分治法求解
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefixByPartion(String[] strs) {
        return partition(strs, 0, strs.length - 1);
    }

    public static String partition(String[] strs, int left, int right) {
        if (left >= right) {
            return strs[left];
        } else {
            int mid = (left + right) / 2;
            String leftStr = partition(strs, left, mid);
            String rightStr = partition(strs, mid + 1, right);
            return resolve(leftStr, rightStr);
        }
    }

    public static String resolve(String leftStr, String rightStr) {
        int len = Math.min(leftStr.length(), rightStr.length());
        for (int i = 0; i < len; i++) {
            if (leftStr.charAt(i) != rightStr.charAt(i)) {
                return leftStr.substring(0, i);
            }
        }
        return leftStr.substring(0,len);
    }


    public static void main(String[] args) {
      //  String[] arr = {"flower", "flow", "flight"};
      //  System.out.println(longestCommonPrefixByPartion(arr));

        String[] arr1 = {"aa", "a"};
        System.out.println(longestCommonPrefixByPartion(arr1));
    }


}
