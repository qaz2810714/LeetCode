package Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 有效的数独
 *
 * 说明:

 一个有效的数独（部分已被填充）不一定是可解的。
 只需要根据以上规则，验证已经填入的数字是否有效即可。
 给定数独序列只包含数字 1-9 和字符 '.' 。
 给定数独永远是 9x9 形式的。
 * @author yang.shang
 * @create 2018-09-05 09:58
 **/
public class IsValidSuduku {
    //不难，联想到SET去重  +  格式化存储信息 很容易就可以解决
    //'4' in row 7 is encoded as "(4)7".
    //'4' in column 7 is encoded as "7(4)".
    //'4' in the top-right block is encoded as "0(4)2".
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                        return false;
                }
            }
        }
        return true;
    }
}
