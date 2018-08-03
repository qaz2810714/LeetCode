package Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers,
 * return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * 给予两个int类型数组，如果两个数字相加到一个特定的目标，返回两个数字的索引
 * 你可以假设每个输入只有1个解决方案，并且不能使用两次相同的元素
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * @author Kince
 * @create 2018-08-03 11:18
 **/
public class TwoSum {

    ///Time complexity : O(n)
    //Space complexity : O(n)
    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map= new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(map.containsKey(temp)){
                return new int[] {map.get(temp),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no Such solution");
    }

    public static void main(String[] args){
        int[] testArray=new int[]{2,4,6,8,23,15,24,13,9,32};
        TwoSum solution=new TwoSum();
        int[] result=solution.twoSum(testArray,11);
        System.out.println(result[0]+"---------"+result[1]);
    }
}
