package Easy;

/**
 * 从排序数组中删除重复项
 *
 * @author yang.shang
 * @create 2018-08-03 14:02
 **/
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums){
        int i=0;
        for (int j=1;j<nums.length;j++){
            if (!(nums[i]==nums[j])){
                nums[i+1]=nums[j];
                i++;
            }
        }
        return i+1;
    }
    public static void main(String[] args){
        RemoveDuplicates test=new RemoveDuplicates();
        int[] testArray=new int[]{1,1,4,4,6,8,9,9,9,10,10};
        int count=test.removeDuplicates(testArray);
        for (int i=0;i<count;i++)
            System.out.println(testArray[i]);
    }
}
