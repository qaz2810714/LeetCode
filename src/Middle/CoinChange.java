package Middle;

/**
 * 零钱收集
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。

 示例 1:

 输入: coins = [1, 2, 5], amount = 11
 输出: 3
 解释: 11 = 5 + 5 + 1
 示例 2:

 输入: coins = [2], amount = 3
 输出: -1
 说明:
 你可以认为每种硬币的数量是无限的
 *
 * @author yang.shang
 * @create 2018-09-30 15:32
 **/
public class CoinChange {

    //典型的动态规划问题，
    //我们定义DP(n)函数代表n金额所需要的最少硬币,则产生下列递推关系式即状态转移方程
    // DP(n)=DP(n-k)+1 k为coins中的元素 因此k可能有多值
    //DP(n)应该是这些k值所产生的DP(n-k)+1中的最小值
    //故 DP(n) = min( DP(n-coins[0])+1, ...... DP(n-coins[coins.length-1])+1 )
    //确定初始值 DP(0)=0;
    //最后通过状态转移方程和初始值从下往上递推出DP(n)即为结果
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        //初始化都为MAX_VALUE
        for (int i = 0; i <dp.length ; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i <amount+1 ; i++) {
            for (int coin : coins){
                int last = i-coin;
                //如果上一个DP点未越界 且 上一个DP点存在
                if (last >= 0 && dp[last] !=-1 )
                    dp[i] = Math.min(dp[i],dp[last] + 1);
            }
            //如果遍历完coin都没得到结果,说明当前DP点不存在 置为-1
            if (dp[i] == Integer.MAX_VALUE)
                dp[i] = -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,3,5};
        int amount = 11;
        System.out.println(new CoinChange().coinChange(coins,amount));
    }
}
