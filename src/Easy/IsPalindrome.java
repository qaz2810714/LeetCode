package Easy;

/**
 * 验证回文字符串
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 *
 * @author yang.shang
 * @create 2018-09-07 10:58
 **/
public class IsPalindrome {

    //双指针一个指向字符串头一个指向字符串尾，依次向中间靠拢
    //如果不用toLowerCase函数的话 需要对大小写进行一个映射处理
    // 'A'-'a' = -32 但是这种情况下会导致一种极端情况 '0'-'P'= 32
    //最后还是使用了toLowerCase() 代码相对简洁很多
    public static boolean isPalindrome(String s) {
        if (s.equals(""))
            return true;
        int i = 0;
        int j = s.length() - 1;
        char[] pchar = s.toLowerCase().toCharArray();
        while (i < j) {
            //判断字符是否为合法字符
            if (('0' <= pchar[i] && pchar[i] <= '9') || ('a' <= pchar[i] && pchar[i] <= 'z')) {
                if (('0' <= pchar[j] && pchar[j] <= '9') || ('a' <= pchar[j] && pchar[j] <= 'z')) {
                    if (pchar[i] == pchar[j]) {
                        i++;
                        j--;
                        continue;
                    }
                    return false;
                }
                j--;
                continue;
            }
            i++;
        }
        return true;
    }

    //上面那段代码简洁性和可读性都比较差
    //下面这种看上去就好多了
    public static boolean isPalindrome2(String s) {
        if (s.equals(""))
            return true;
        int start = 0;
        int end = s.length() - 1;
        char[] pchar = s.toLowerCase().toCharArray();
        while (start < end) {
            char pre=pchar[start];
            char aft=pchar[end];
            if (!(('0' <= pre && pre <= '9') || ('a' <= pre && pre <= 'z'))) {
                start++;
                continue;
            }
            if (!(('0' <= aft && aft <= '9') || ('a' <= aft && aft <= 'z'))) {
                end--;
                continue;
            }
            if (pre != aft)
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
        System.out.println('0' - 'P');
    }
}
