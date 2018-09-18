package Easy;

import java.util.Arrays;

/**
 * 整数并说
 *
 * 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 被读作  "one 1"  ("一个一") , 即 11。
 11 被读作 "two 1s" ("两个一"）, 即 21。
 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

 给定一个正整数 n ，输出报数序列的第 n 项。

 注意：整数顺序将表示为一个字符串。

 示例 1:

 输入: 1
 输出: "1"
 示例 2:

 输入: 4
 输出: "1211"
 *
 * @author yang.shang
 * @create 2018-09-10 11:17
 **/
public class CountAndSay {
    public static String countAndSay(int n) {
        String pre="1";
        int count=1;
        char[] pre_array=pre.toCharArray();
        char pre_char=pre_array[0];
        for (int i = 1; i <n ; i++) {
            StringBuilder next=new StringBuilder();
            for (int j=1;j<pre_array.length;j++){
                char nextchar=pre_array[j];
                if (pre_char == nextchar)
                    count++;
                else{
                    next.append(count).append(pre_char);
                    pre_char = nextchar;
                    count = 1;
                }
            }
            next.append(count).append(pre_char);
            count=1;
            pre_array=next.toString().toCharArray();
            pre_char=pre_array[0];
        }
        return String.valueOf(pre_array);
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(3));
    }
}
