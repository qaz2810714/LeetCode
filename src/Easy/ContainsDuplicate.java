package Easy;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 存在重复
 *
 * @author yang.shang
 * @create 2018-08-07 16:43
 **/
public class ContainsDuplicate implements Serializable {
    //空间复杂度O(n),时间复杂度O(n)
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++)
            map.put(nums[i],i);
        return map.size() != nums.length;
    }
    //空间复杂度O(1),时间复杂度O(n)，感觉差不多
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]==nums[i+1])
                return true;
        }
        return false;
    }
}
