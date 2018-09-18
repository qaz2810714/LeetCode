package Easy;

/**
 * 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * @author yang.shang
 * @create 2018-09-10 14:01
 **/
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int min_size = Integer.MAX_VALUE;
        //先求所有字符串的公共最小长度
        for (String index : strs) {
            if (index.length() < min_size)
                min_size = index.length();
        }
        char cur_char;
        StringBuilder common = new StringBuilder();
        for (int i = 0; i < min_size; i++) {
            cur_char = strs[0].charAt(i);
            for (String str : strs) {
                if (cur_char != str.charAt(i))
                    return common.toString();
            }
            common.append(cur_char);
        }
        return common.toString();
    }

    public static void main(String[] args) {
        String[] test = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(test));
    }
}
