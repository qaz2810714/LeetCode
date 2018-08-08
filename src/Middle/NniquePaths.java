package Middle;

/**
 * 不同路径
 *
 * @author yang.shang
 * @create 2018-08-06 16:45
 **/
public class NniquePaths {
    //递归算法
    public int uniquePaths(int m,int n){
        int count;
        if (m==1||n==1)
            return 1;
        if  (m==2 || n==2)
            count= Math.max(m,n);
        else
            count= uniquePaths(m-1,n)+uniquePaths(m,n-1);
        return count;
    }
    //非递归算法 缺陷在于对于m*n的棋盘 每个棋盘点都要储存
    public int uniquePaths2(int m,int n){
        int[][] count=new int[m][n];
        if (m==1||n==1)
            return 1;
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++){
                if (i==1||j==1){
                    count[i-1][j-1]=1;
                }
                else{
                    count[i-1][j-1]=count[i-2][j-1]+count[i-1][j-2];
                }
            }
        }
        return count[m-1][n-1];
    }
    public static void main(String[] args){
        NniquePaths test=new NniquePaths();
        System.out.println(test.uniquePaths2(7,3));
    }
}
