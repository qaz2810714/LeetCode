package Easy;

/**
 * 汉明重量
 *
 *
 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。

 示例 :

 输入: 11
 输出: 3
 解释: 整数 11 的二进制表示为 00000000000000000000000000001011


 示例 2:

 输入: 128
 输出: 1
 解释: 整数 128 的二进制表示为 00000000000000000000000010000000

 * @author yang.shang
 * @create 2018-09-17 15:37
 **/
public class HammingWeight {

    //右移操作即可，注意要无符号右移
    //  >>是带符号的右移，如果是正数则在高位补零，负数则补1
    //  >>>是无符号右移，在高位补零
    public int hammingWeight(int n) {
        int count=0;
        while (n != 0) {
            if ( (n & 1) == 1 )
                count++;
            n >>>=1;
        }
        return count;
    }

    public static void main(String[] args) {
        HammingWeight test=new HammingWeight();
        System.out.println(test.hammingWeight(-2147483648));
    }
}
