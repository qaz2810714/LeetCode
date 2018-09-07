package Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 *
 * @author yang.shang
 * @create 2018-09-06 14:30
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.


注意事项：您可以假定该字符串只包含小写字母。
 **/
public class FirstUniqChar {

    //使用了一个辅助Map容器 解决方法不太好，由于需要保存插入顺序
    //本来想到Java里的LinkedHashMap 但估计时间复杂度只会更大，只能遍历两次了
    public static int firstUniqChar(String s){
        char[] schar=s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0;i<schar.length;i++){
            if (map.containsKey(schar[i]))
                map.put(schar[i],-1);
            else{
                map.put(schar[i],i);
            }
        }
        for (char aSchar : schar) {
            if (map.containsKey(aSchar) && map.get(aSchar) != -1)
                return map.get(aSchar);
        }
        return 0;
    }

    //LeetCode上没有用Map来进行，利用了题目的性质：只有小写字母
    //将其转换成了一个26定长的数组 数组的索引值代表了字母相对小写字母a的偏移量
    // 对应的索引值 代表其出现次数
    //做法确实很巧妙，其中时间复杂度为O(2n) 空间复杂度为O(1)
    //不过对比上面的做法来说更多的是简洁了点 由于题限制了小写字母所以上面的解法也是O(1)空间复杂度
    public int firstUniqChar2(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

}
