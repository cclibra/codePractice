package leetcode.Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 题目描述：
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * <p>
 * 思路：首先计算给定字符串中每种字符对应的数量，
 * 然后使用双指针，首先移动左指针直至保证中间窗口的字符串中每种字符均达到要求，这里还要使用另一个map维护达标状态。
 * 达到要求后，移动右指针缩小窗口，直至不满足条件，则可得到一种符合要求字串，记录长度，选择最短即可。
 */
public class leetcode76_minWindow {
    public String minWindow(String s, String target) {
        if (s == null || target == null || target.length() > s.length()) return "";
        //构建target的字符数量表
        Map<Character, Integer> tCharMap = new HashMap<>();
        char[] tCharArr = target.toCharArray();
        for (char tmp : tCharArr) {
            tCharMap.put(tmp, tCharMap.getOrDefault(tmp, 0) + 1);
        }
        //建立已经匹配的字符数量表
        Map<Character, Integer> matchedCharMap = new HashMap<>();
        int machedCharNum = 0;
        long minLen = Long.MAX_VALUE;
        String res = "";
        int n = s.length();
        int j = 0;
        char[] sArr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            while (j < n && machedCharNum < tCharMap.size()) {
                char tmp_right = sArr[j];
                matchedCharMap.put(tmp_right, matchedCharMap.getOrDefault(tmp_right, 0) + 1);
                if (Objects.equals(tCharMap.get(tmp_right), matchedCharMap.get(tmp_right))) machedCharNum++;
                j++;
            }
            if (machedCharNum == tCharMap.size())
                if (minLen > j - i) {
                    minLen = j - i;
                    res = String.valueOf(sArr, i, j - i);
                }
            char tmp_left = sArr[i];
            matchedCharMap.put(tmp_left, matchedCharMap.get(tmp_left) - 1);
            if ((tCharMap.getOrDefault(tmp_left, 0) - matchedCharMap.getOrDefault(tmp_left, 0) == 1))
                machedCharNum--;
        }
        return minLen == Long.MAX_VALUE ? "" : res;
    }
}
