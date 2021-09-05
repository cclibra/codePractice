package othercode.DP;

/**
 * 题目描述：
 * 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * 示例 1:
 * <p>
 * 输入:
 * [[1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * <p>
 * 思路：
 * 使用动态规划，构造dp数组，dp[i][j]代表从grid[0][0]到的最多价值礼物数
 * 则转移方程为dp[i][j]=max[dp[i][j−1],dp[i−1][j]]+grid[i][j]，同时要注意边界问题。
 */
public class maxValueParent {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp1 = i == 0 ? 0 : dp[i - 1][j];
                int tmp2 = j == 0 ? 0 : dp[i][j - 1];
                dp[i][j] = Math.max(tmp1, tmp2) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
