package Easy;

/**
 * 旋转数组
 *
 * @author yang.shang
 * @create 2018-08-06 13:36
 **/
public class RotateArray {
    public void rotateArray(int[] nums,int k){
        k=k % nums.length;
        int count=0;
        int start=0;
        int current=start;
        int prev=nums[start];
        do {
            int next=(current+k)%nums.length;
            int temp=nums[next];
            nums[next]=prev;
            prev=temp;
            current=next;
            count++;
        }
        while (start != current && count<nums.length);
    }
    public static void main(String[] args){
        RotateArray test=new RotateArray();
        int[] testArray=new int[]{1,2,3,4,5,6,7,8,9,0,10};
        int k=3;
        test.rotateArray(testArray,k);
        for (int i:testArray){
            System.out.println(i);
        }
    }
}
