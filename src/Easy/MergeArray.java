package Easy;

/**
 * 合并2个有序数组
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

 说明:

 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 示例:

 输入:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 输出: [1,2,2,3,5,6]
 *
 * @author yang.shang
 * @create 2018-09-17 11:09
 **/
public class MergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int size=m+n;
        int[] temp=new int[size];
        int left=0;
        int right=0;
        for(int i=0;i<size;i++){
            if(left > m-1){
                temp[i]=nums2[right];
                right++;
                continue;
            }
            if(right > n-1){
                temp[i]=nums1[left];
                left++;
                continue;
            }
            if(nums1[left] < nums2[right] ){
                temp[i]=nums1[left];
                left++;
            }
            else{
                temp[i]=nums2[right];
                right++;
            }
        }
        for(int i=0;i<size;i++){
            nums1[i]=temp[i];
        }
    }

    public static void main(String[] args) {
        int[] testA=new int[]{1,2,3,0,0,0};
        int[] testB=new int[]{2,5,6};
        MergeArray test=new MergeArray();
        test.merge(testA,3,testB,3);
        for (int a:testA){
            System.out.print(a);
        }
    }
}
