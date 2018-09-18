package Easy;

/**
 * 缺失数字
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

 示例 1:

 输入: [3,0,1]
 输出: 2
 示例 2:

 输入: [9,6,4,2,3,5,7,0,1]
 输出: 8
 说明:
 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 *
 * @author yang.shang
 * @create 2018-09-17 14:01
 **/
public class MissingNumber {

    //时间复杂度O(n) 空间复杂度O(1) 唯一的缺点在于这种算法可能会造成溢出
    public int missingNumber(int[] nums){
        int size=nums.length;
        int sum=size;
        int cur;
        for (int i = 0; i < size; i++) {
            cur = nums[i];
            sum = sum + i - cur;
        }
        return sum;
    }

    //第二种解法，更加优雅清晰 也不会发生溢出
    // 0 - n 的数组如果发生缺失数字k 那么让这个数组和正常的数组0 - n 进行异或操作即可得到 k
    public int missingNumber2(int[] nums){
        int size=nums.length;
        int result=nums.length-1;
        for (int i = 0; i <size ; i++) {
            result = result ^ i ^ nums[i];
        }
        return result;
    }
}
