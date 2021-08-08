package leetcode.DP;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 题目描述：
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，
 * 判定s是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * <p>
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * 思路：
 * 可以使用dp数组保存subString(0,k)的字符串能否用字典中的单词切分。
 * 然后用两层循环逐个判断subString(0,k)的字符串是否可以被切分。
 */
public class leetcode139_wordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null) return false;
        int length = s.length();
        Set<String> wordSet = new HashSet(wordDict);
        //创建dp数组，初始化值均为false
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                //如果前j段字符串可分割，j到i部分也可分割，那么前i段字符串认为可分割
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
            if (dp[length]) break;
        }
        return dp[length];
    }
}
