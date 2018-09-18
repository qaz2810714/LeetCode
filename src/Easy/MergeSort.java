package Easy;

/**
 * 归并排序
 *
 * 很经典的算法 利用分治解决问题
 *
 * @author yang.shang
 * @create 2018-09-14 10:38
 **/
public class MergeSort {

    public static void mergeSort(int[] nums){
        int[] temp=new int[nums.length];
        sort(nums,0,nums.length-1,temp);
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }

    private static void sort(int[] array,int start,int end,int[] temp){
        if (start<end){
            int mid=(start+end)/2;
            sort(array,start,mid,temp);
            sort(array,mid+1,end,temp);
            merge(array,start,mid,end,temp);
        }
    }

    private static void merge(int[] array,int start,int mid,int end,int[] temp){
        int left=0;
        int right=0;
        //两个数组
        // 第一个数组0-mid(首尾都包括)
        // 第2个数组mid+1 - end(首尾都包括)
        for (int i=start;i<end+1;i++){
            //如果第一个数组已经全部提交完
            if (start+left > mid){
                temp[i]=array[mid+1+right];
                right++;
                continue;
            }
            //如果第二个数组已经全部提交完
            if (mid+1+right > end){
                temp[i]=array[start+left];
                left++;
                continue;
            }

            //如果两个数组都没提交完
            //依次对比两个子数组的各个元素大小，小的加入到新的数组temp中
            if (array[start+left] < array[mid+1+right]){
                temp[i]=array[start+left];
                left++;
            }
            else{
                temp[i]=array[mid+1+right];
                right++;
            }
        }
        //合并完成后，把临时数组里的排序好的内容拷贝到array里去
        System.arraycopy(temp, start, array, start, end + 1 - start);
        //其实就是下面这种写法的简化.....
//        for (int i=start;i<end+1;i++){
//            array[i]=temp[i];
//        }
    }

    public static void main(String[] args) {
        int[] testArray=new int[]{5,4,2,7,42,74,6,82,4,1};
        MergeSort.mergeSort(testArray);
        for (int n:testArray)
            System.out.print( n +"   ");
    }
}
