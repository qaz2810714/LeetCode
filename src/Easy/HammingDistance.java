package Easy;

/**
 * 汉明距离
 *
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

 给出两个整数 x 和 y，计算它们之间的汉明距离。

 注意：
 0 ≤ x, y < 2^31.

 示例:

 输入: x = 1, y = 4

 输出: 2

 解释:
 1   (0 0 0 1)
 4   (0 1 0 0)
 ↑   ↑

 上面的箭头指出了对应二进制位不同的位置。
 *
 * @author yang.shang
 * @create 2018-09-17 15:51
 **/
public class HammingDistance {

    //循环右移，判断1的个数即可
    public int hammingDistance(int x, int y) {
        //先异或运算
        int result=x^y;
        int count=0;
        while (result != 0){
            if ((result & 1) == 1)
                count++;
            result >>>=1;
        }
        return count;
    }

    public static void main(String[] args) {
        HammingDistance test= new HammingDistance();
        int a=test.hammingDistance(93,73);
        System.out.println(a);
    }
}
