package Middle;

/**
 * 跳跃游戏
 *
 * @author yang.shang
 * @create 2018-09-05 17:20
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 **/
public class CanJump {


    //DP算法  n代表距离终点的距离n DP(n)代表当前点是否可以到达终点
    // DP(n)= ||( DP(n-x) )   ( x=A(n) ||为所有x取值下DP(n-x)结果的并集    )
    //初始值 DP(0) = true
    //时间复杂度O(n^2) 空间复杂度O(n)  如果想精简空间复杂度，可以考虑不使用辅助数组DP
    //每次计算完索引值为[size-1-i]是否可以 到达终点时 则将该值置为某个flag位
    public static boolean canJump(int[] nums){
        int size=nums.length;

        boolean[] dp=new boolean[size];
        int max_jump;
        dp[0]=true;
        //从后往前进行索引 i代表距离终点的距离 nums[size-1-i]代表当前点所能跳跃的最大距离
        for(int i=1;i<size;i++){
            max_jump=nums[size-1-i];
            //如果当前点距离终点的距离 比跳跃的距离小,则代表当前值可以跳到终点
            if (max_jump>=i)
                dp[i]=true;
            //否则的话，判断所有子DP 只要其中有一个子DP为true则该点为true，否则为false
            else{
                for (int j=1;j<=max_jump;j++){
                    if (dp[i-j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        //执行完以后，dp[size-1]即为结果
        return dp[size-1];
    }

    //上面的算法 时间复杂度O(N^2) 空间复杂度为O(n)（应该可以优化成O(1)）
    //实在不算什么好办法。。。 这题应该用贪心算法来求解
    //我们可以用一个指针good指向这个数组最左端的已经判明 可以到达终点的点 初始值为数组最末点
    //那么接下来的点是否可以到达终点只要判明 这个点是否可以到达good点即可
    // 因为他想到达终点 在这个点上 所需要的最小移动距离 即为到good点的距离
    //太牛逼了
    public static boolean canJump2(int[] nums){
        int size=nums.length;
        //reach代表 数组最左端的已经判明 可以到达终点的点 的索引值
        int reach=size-1;
        for (int i=size-2;i>-1;i--){
            //判断是否可以到达reach点 如果该点可以到达，则reach 置为该点
            if (nums[i]>=reach-i)
                reach=i;
        }
        return true;
    }

}
