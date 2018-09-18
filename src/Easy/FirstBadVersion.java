package Easy;

/**
 * 第一个错误的版本
 *
 *
 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。

 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。

 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。

 示例:

 给定 n = 5，并且 version = 4 是第一个错误的版本。

 调用 isBadVersion(3) -> false
 调用 isBadVersion(5) -> true
 调用 isBadVersion(4) -> true

 所以，4 是第一个错误的版本。
 *
 * @author yang.shang
 * @create 2018-09-17 11:41
 **/
public class FirstBadVersion {
    private int n;
    private long version;
    public FirstBadVersion(int n,int version){
        this.n=n;
        this.version=version;
    }

    private boolean isBadVersion(int cur){
        return cur >= version;
    }
    public int firstBadVersion(int n) {
        int start=1;
        if (isBadVersion(start))
            return start;
        int end = n;
        while(end - start > 1){
            //一个巧妙的陷阱 直接用(start+end)/2 可能会发生溢出 应该用下面这种方式避免
            int mid=start+ (end-start)/2;
            boolean midversion=isBadVersion(mid);
            if(midversion)
                end=mid;
            else{
                start=mid;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        FirstBadVersion test=new FirstBadVersion(2126753390,1702766719);
        System.out.print(test.firstBadVersion(2126753390));
    }
}
