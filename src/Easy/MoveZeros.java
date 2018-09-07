package Easy;

/**
 * 移动0
 *
 * @author yang.shang
 * @create 2018-09-06 13:40
 **/
public class MoveZeros {

    //时间复杂度O(n) 空间复杂度O(1)
    public static void moveZeros(int[] nums) {
        //一个变量指示往左移动的位数 同时也是数组中0的数量
        int left_move = 0;
        //下面这个迭代把不为0的数置到正确的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                left_move++;
            else {
                nums[i - left_move] = nums[i];
            }
        }
        //下面这个迭代在数组尾部补0
        for (int i = 1; i <= left_move; i++) {
            nums[nums.length - i] = 0;
        }
    }
}

    //LeetCode上有另一种实现，用以解决 类似0 0 0 0 1这种 情景下的复杂度 当然在最坏情况下，与上述算法一样
    //C++
//    void moveZeroes(vector<int>& nums) {
//        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.size(); cur++) {
//            if (nums[cur] != 0) {
//                swap(nums[lastNonZeroFoundAt++], nums[cur]);
//            }
//        }
//    }
//}
