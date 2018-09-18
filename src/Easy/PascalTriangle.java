package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 帕斯卡三角
 *
 * @author yang.shang
 * @create 2018-09-13 16:07
 **/
public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> preList=new ArrayList<>();
        if (numRows == 0)
            return result;
        //第一行
        preList.add(1);
        List<Integer> curList;
        result.add(preList);
        for (int i = 2; i <= numRows ; i++) {
            //分配容量
            curList=new ArrayList<>(i);
            //当前行第一个值
            curList.add(preList.get(0));
            //中间值
            for (int j = 1; j <i-1 ; j++) {
                curList.add(preList.get(j-1)+preList.get(j));
            }
            //当前行最后一个值
            curList.add(preList.get(0));
            preList=curList;
            result.add(curList);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result=PascalTriangle.generate(10);
        for (List<Integer> curList:result){
            for (int n:curList)
                System.out.print(n+"   ");
            System.out.println("  ");
        }
    }
}
