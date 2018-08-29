package Easy;

/**
 * 爬楼梯
 *
 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 注意：给定 n 是一个正整数。
 *
 * @author yang.shang
 * @create 2018-08-28 16:23
 **/
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n==1)
            return 1;
        if (n==2)
            return 2;
        int i=1;
        int j=2;
        int m=2;
        for (int k = 2; k <= n; k++) {
            if (k==n)
                return m;
            else{
                m=i+j;
                i=j;
                j=m;
            }
        }
        return 0;
    }
}
