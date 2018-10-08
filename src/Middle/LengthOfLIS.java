package Middle;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。

 示例:

 输入: [10,9,2,5,3,7,101,18]
 输出: 4
 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 说明:

 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 你算法的时间复杂度应该为 O(n2) 。
 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

 * @author yang.shang
 * @create 2018-09-30 16:36
 **/
public class LengthOfLIS {

    //最大连续子序列之和 问题的变种
    //同样是DP算法 DP(n)代表以An结尾的最长上升子序列长度
    //结果 result=Max( DP(0) .....DP(n) )
    //DP(n) = A(n)>A(n-1)? DP(n-1)+1:1
    //初始值DP(1)=1
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max=1;
        int cur=1;
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i] > nums[i-1])
                cur++;
            else {
                cur=1;
            }
            max = Math.max(max,cur);
        }
        return max;
    }

    //理解错了 应该是 最大利润值问题的变种
    //结果应该为峰顶值和峰底值的最大差，然后求中间的序列数
    //其实本质还是最大连续子序列之和
    public int lengthOfLIS2(int[] nums) {
        int min=Integer.MAX_VALUE;
        for (int i = 0; i <nums.length ; i++) {

        }
        return 0;
    }
}
