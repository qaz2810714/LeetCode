package Easy;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 反转字符串
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。

 示例 1:

 输入: "hello"
 输出: "olleh"
 示例 2:

 输入: "A man, a plan, a canal: Panama"
 输出: "amanaP :lanac a ,nalp a ,nam A"
 *
 * @author yang.shang
 * @create 2018-09-03 16:52
 **/
public class ReverseString {

    //两个指针 1个头部一个尾部 遍历交换 O(n)级复杂度
    public static String reverseString(String s){
        byte[] result=s.getBytes();
        int i=0;
        int j=s.length()-1;
        byte temp;
        while (i<j){
            temp=result[i];
            result[i]=result[j];
            result[j]=temp;
            i++;
            j--;
        }
        return new String(result);
    }
}
