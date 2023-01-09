package leetcode.Array;

/**
 * 题目描述：最短单词距离
 *
 */
public class leetcode243_shortestDistance {
    public int shortestDistance(String[] words, String word1, String word2){
        int a = -1;
        int b = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++){
            String curWord = words[i];
            if(word1.equals(curWord)){
                a = i;
            }
            if(word2.equals(curWord)){
                b = i;
            }
            if(a >= 0 && b >= 0){
                res = Math.min(res, (Math.abs(a - b)));
            }
        }
        return res;
    }
}
