package Easy;

/**
 * 买卖股票的最佳时机
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

 注意你不能在买入股票前卖出股票。
 *
 * @author yang.shang
 * @create 2018-08-06 09:26
 **/
public class MaxProfit {

    //这题的标签是DP，想了1个小时实在没想到有什么DP算法可以解决此问题，跑去看答案
    //结果答案居然用的是遍历每个点，再进行子查询的O(n)算法,倒不是不能解决，但总感觉缺点什么
    //看到讨论区有个Kadane最大连续子列和算法，了解了一下，只能感觉一句卧槽了，下列将两种算法都列举出来
    public int maxProfit(int[] prices){
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }


    //Kadane最大连续子列和算法 两点之间的距离差 即为连续和的数组元素A(n)
    //状态转移方程DP(n)=Max(A(n),DP(n-1)+A(n))
    //DP(n)代表的是以n序号元素 结尾的最大连续子串和
    //从而计算出每一点的DP以后，再取其中的最大值   MAX(DP(1),DP(2),DP(3),...)
    //简洁又清晰 不过从效率上来说两个算法差异不大，都是O(n)复杂度
    public int maxProfit2(int[] prices){
        int max_ending_here, max_so_far;
        max_ending_here = max_so_far =0;
        for(int n = 1; n < prices.length; n++){
            max_ending_here = Math.max(max_ending_here + prices[n] - prices[n-1], prices[n] - prices[n-1]);
            max_so_far = Math.max(max_ending_here, max_so_far);
        }
        return max_so_far;
    }


    public static void main(String[] args){
        MaxProfit test=new MaxProfit();
        int[] testArray=new int[]{2,9,7,4,6,2,5,4,7,10,3};
        int result=test.maxProfit(testArray);
        System.out.println(result);
    }
}
