package Easy;

/**
 * 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的
 * 防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

 示例 1:

 输入: [1,2,3,1]
 输出: 4
 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 偷窃到的最高金额 = 1 + 3 = 4 。
 示例 2:

 输入: [2,1,1,2]
 输出: 4
 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 4 号房屋 (金额 = 2)
 偷窃到的最高金额 = 2 + 2 = 4 。
 *
 * @author yang.shang
 * @create 2018-09-03 16:16
 **/
public class HouseRobber {

    // DP算法 对于n个房屋的最大金额为DP(n)
    // 小偷可以选择偷和不偷第n家  当偷第n家时DP(n)=DP(n-2)+n (偷了n就不能偷 n-1)
    // 不偷第n家 DP(n)=DP(n-1)
    // 取两者最大值 可得状态转移方程 DP(n)=MAX( DP(n-2)+n,DP(n-1) )
    // 时间复杂度O(n) 空间复杂度O(1)
    public static int rob(int[] nums){
        //边界值
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        //初始值
        int tempMoney=nums[0];
        int maxMoney=Math.max(nums[0],nums[1]);
        int maxRob;

        for (int i=2;i<nums.length;i++){
            maxRob=Math.max(tempMoney+nums[i],maxMoney);
            tempMoney=maxMoney;
            maxMoney=maxRob;
        }
        return maxMoney;

    }

    public static void main(String[] args){
        int[] testArray={2,1,1,2,7,4,1,2,3,24};
        System.out.println(HouseRobber.rob(testArray));
    }
}
