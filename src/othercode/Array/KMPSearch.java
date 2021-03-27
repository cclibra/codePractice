package othercode.Array;

/**
 * KMP字符串匹配
 */
public class KMPSearch {
    //构建dp数组，含义为pat的状态转移数组，
    // dp[j][c] = next 代表j状态在遇到字符c时应转移的next状态
    // j代表当前的状态, c代表遇到的字符（ASCII 码）
    private int[][] dp;
    private String pat;

    public KMPSearch(String pat) {
        this.pat = pat;
        int M = pat.length();
        //dp[状态][字符]=下个状态
        dp = new int[M][256];
        //base case.只有遇到pat的第一个字符，才会进到状态1
        dp[0][pat.charAt(0)] = 1;
        //初始化影子状态X
        int X = 0;
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
                if (pat.charAt(j) == c) {
                    //状态推进
                    dp[j][c] = j + 1;
                } else {
                    //状态重启，委托影子状态X进行计算
                    dp[j][c] = dp[X][c];
                }
            }
            //更新下一次的影子状态，为本次影子状态遇见本次字符的状态
            //这样下一个状态重启时，找到的就是本次（上一次）遇见字符的状态
            X = dp[X][pat.charAt(j)];

        }


    }

    public int search(String txt) {
        if (null == txt || pat == null) return -1;
        int M = pat.length();
        int N = txt.length();
        //初始化pat的状态
        int j = 0;
        for (int i = 0; i < N; i++) {
            //遍历整个txt，根据txt的字符获取pat的状态转移
            j = dp[j][txt.charAt(i)];
            //达到终止态，返回匹配开头的索引
            if (j == M) return i - M + 1;
        }
        //没达到终止态，匹配失败，返回-1
        return -1;
    }

}
