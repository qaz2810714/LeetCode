package Easy;

/**
 * 实现strStr()
 * 实现 strStr() 函数。

 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

 示例 1:

 输入: haystack = "hello", needle = "ll"
 输出: 2
 示例 2:

 输入: haystack = "aaaaa", needle = "bba"
 输出: -1
 说明:

 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * @author yang.shang
 * @create 2018-09-07 13:39
 **/
public class StrStr {

    //有个算法KMP，就是用来解决子串问题的
    //这个问题的主要优化点在于 在母串中寻找子串  必须要遍历母串
    //如果当前指针不和子串完全匹配时，通常做法是向右移动指针
    //但这样 已匹配的部分就被放弃，又要重新从新指针处开始重新匹配
    //解决这个问题的思路是 我们可以储存 已匹配的位数k 然后然后向右移动k位
    public static int strStr(String haystack, String needle) {
        if (needle.equals(""))
            return 0;
        int start=0;
        int k=0;
        while (start<haystack.length()){
            char cur=haystack.charAt(start);
            char need=needle.charAt(k);
            if (cur == need){
                start++;
                k++;
                if (k == needle.length())
                    return start-k;
            }
            else{
                start=start+k+1;
                k=0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi","issip"));
    }
}
