package Middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 工作瀑
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 *
 * @author yang.shang
 * @create 2019-09-19 16:06
 **/
public class WorkBook {

    public static boolean canSegmented(String s, List<String> wordDict){
        //创建一个DP数组
        boolean[] dp = new boolean[s.length()];
        for (int i=0;i<dp.length;i++){
            String childStr = s.substring(0,i+1);
            for (String dict:wordDict){
                if (dict.equals(childStr)) {
                    dp[i] = true;
                    break;
                }
                int dictLength = dict.length();
                if (i-dictLength >=0 && dp[i-dictLength] && childStr.substring(childStr.length()-dictLength).equals(dict)){
                    dp[i] = dp[i-dictLength];
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        List<String> wordDic = new ArrayList<>();
//        wordDic.add("cats");
//        wordDic.add("dog");
//        wordDic.add("sand");
//        wordDic.add("and");
//        wordDic.add("cat");
        wordDic.add("a");
        wordDic.add("b");
//        System.out.println(canSegmented("catsandog",wordDic));
        System.out.println(canSegmented("ab",wordDic));
    }
}
