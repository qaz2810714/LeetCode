package Easy;

/**
 * 买卖股票的最佳时机
 *
 * @author yang.shang
 * @create 2018-08-06 09:26
 **/
public class MaxProfit {
    public int maxProfit(int[] nums){
        int count=0;
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]<nums[i+1]){
                count=count+ nums[i+1]-nums[i];
            }
        }
        return count;
    }
    public static void main(String[] args){
        MaxProfit test=new MaxProfit();
        int[] testArray=new int[]{2,9,7,4,6,2,5,4,7,9,3};
        int result=test.maxProfit(testArray);
        System.out.println(result);
    }
}
