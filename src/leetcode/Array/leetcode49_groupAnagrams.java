package leetcode.Array;

import java.util.*;

/**
 * 题目描述： 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 */
public class leetcode49_groupAnagrams {
    public static void main(String[] args) {
        String[] rrr = {"eat","tea","tan","ate","nat","bat"};
        new leetcode49_groupAnagrams().groupAnagrams(rrr);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs){
            char[] curr = str.toCharArray();
            Arrays.sort(curr);
            String key = new String(curr);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
         for (List<String> list : map.values()){
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
