package othercode.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述：
 * 给定一个仅包含小写字母的字符串 S.
 * 返回 S 中至少包含 k个不同字符的子串的数量。
 * 样例：
 * 样例 1:
 * 输入: S=“abcabcabca”，k = 4
 * 输出: 0
 * 样例 2:
 * 输入: S = "abcaac", k = 2
 * 输出: 14
 * <p>
 * 思路：
 * 字串为连续的字符组合，这里可使用同向双指针，控制并判断前后指针间字串是否满足条件。
 * 使用哈希表记录字串中每个字符出现次数，并随指针更新。
 * 注：若某个字串满足条件时，以该字串开头的所有大于该长度的字串也均符合要求。
 */
public class kDistinctCharSubstring {
    public long kDistinctCharSubstr(String s, int k) {
        if (s == null || s.length() == 0 || k < 0 || k > s.length()) {
            return 0;
        }
        int n = s.length();
        long num = 0;
        //不同字符的数量
        int diffCharNum = 0;
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;//右指针
        for (int i = 0; i < n - 1; i++) {//左指针
            while (j < n && diffCharNum < k) {
                //右指针的字符增加市，判断是不是新出现的字符，做map表和diffCharNum更新操作
                char tmp_right = s.charAt(j);
                map.put(tmp_right, map.getOrDefault(tmp_right, 0) + 1);
                if (map.get(tmp_right) == 1) diffCharNum++;
                j++;
            }
            //注意，此处的j是在上面j++的基础上又增加了1，因此应该为n - 1 - (j - 1) + 1
            if (diffCharNum == k) num += n - j - 1;
            //左指针的字符增加市，判断是不是独有的字符，同样做map表和diffCharNum更新操作
            char tmp_left = s.charAt(i);
            map.put(tmp_left, map.get(tmp_left) - 1);
            if (map.get(tmp_left) == 0) diffCharNum--;
        }
        return num;
    }
}
