package Easy;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 打乱数组
 *
 * 打乱一个没有重复元素的数组。

 示例:

 // 以数字集合 1, 2 和 3 初始化数组。
 int[] nums = {1,2,3};
 Solution solution = new Solution(nums);

 // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 solution.shuffle();

 // 重设数组到它的初始状态[1,2,3]。
 solution.reset();

 // 随机返回数组[1,2,3]打乱后的结果。
 solution.shuffle();
 *
 * @author yang.shang
 * @create 2018-09-10 15:11
 **/
public class ShuffleArray {
    private  int[] old_array;
    private Random random;

    public ShuffleArray(int[] nums){
        old_array=nums;
        random=new Random();
    }

    public int[] reset(){
        return old_array;
    }

    //Fisher-Yates算法 算法的基本思想是
    //迭代数组 一个指针 i 指向当前索引,初始值为数组头 一个指针 j 指向数组尾
    //在算法的迭代过程中 ,每次取 i j 索引中的一个随机元素与i索引对应元素交换(包括 i索引自身)
    //时间复杂度O(n) 空间复杂度O(n) 因为需要一个额外数组保存初始数组以维持reset方法

    //如何证明这是一个分布均匀的随机算法呢?
    // 假如数组的大小是n 那么很容易得最终将有n!种排列组合顺序
    // 而在迭代过程中 第i个元素会在n-i+1个元素中进行选择交换 每次交换都是i和第n-i+1个元素进行交换，故不可能发生同样的2个元素重复交换
    // 一共会发生 (n-1+1)+(n-2+1)+...(n-3+1)+...(n-n+1)=n!个交换，每次交换的组合都是不同的元素组合 故排列组合 为n!种 证明为分布均匀
    public int[] shuffle(){
        int[] new_array=new int[old_array.length];
        System.arraycopy(old_array,0,new_array,0,old_array.length);
        int j;
        for (int i=0;i<new_array.length;i++){
            j=random.nextInt(new_array.length-i)+i;
            swap(new_array,i,j);
        }
        return new_array;
    }

    private void swap(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    public static void main(String[] args) {
        int[] test =new int[]{1,2,3};
        ShuffleArray TEST=new ShuffleArray(test);
        int[] result=TEST.shuffle();
        for (int a:result)
            System.out.println(a);
        int[] reset=TEST.reset();
        for (int a:reset)
            System.out.println(a);
    }
}
