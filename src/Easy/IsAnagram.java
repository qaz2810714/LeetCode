package Easy;

import java.util.Arrays;

/**
 * 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。

 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:

 输入: s = "rat", t = "car"
 输出: false
 说明:
 你可以假设字符串只包含小写字母。

 进阶:
 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @author yang.shang
 * @create 2018-09-06 15:13
 **/
public class IsAnagram {

    //直接转成byte数组，然后全部^操作不就行了。。。
    //不能这样干 s={a,a} t={b,b} 就完蛋了
    public boolean isAnagram(String s, String t) {
        byte[] bytes=s.getBytes();
        byte[] bytet=t.getBytes();
        if (bytes.length == 0)
            return bytet.length == 0;

        int result=bytes[0];
        for (int i = 1; i <bytes.length ; i++) {
            result=result^bytes[i];
        }
        for (byte j:bytet)
            result=result^j;
        return  result == 0;
    }

    //借鉴了 FirstUniqChar 中的方法 最后结尾用了JDK取巧的方式验证2个数组是否相同 也可以手撕
    //瞅了眼标答是遍历判断2个数组是否相同，本质是一样的
    public static boolean isAnagram2(String s, String t) {
        int[] ints=new int[26];
        int[] intt=new int[26];
        for (char a:s.toCharArray())
            ints[a-'a']++;
        for (char a:t.toCharArray())
            intt[a-'a']++;
        return Arrays.equals(ints, intt);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram2("anagram","nagaram"));
    }
}
