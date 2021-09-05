package othercode.Array;

/**
 * 题目描述：
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 * <p>
 * 思路：使用BFS，根据可达解的结构和连通性，易推出机器人可 仅通过向右和向下移动，访问所有可达解 。
 * 递归参数： 当前元素在矩阵中的行列索引 i 和 j ，两者的数位和 si, sj 。
 * 终止条件： 当 ① 行列索引越界 或 ② 数位和超出目标值 k 或 ③ 当前元素已访问过 时，返回 00 ，代表不计入可达解。
 * 递推工作：
 * 标记当前单元格 ：将索引 (i, j) 存入 visited 中，代表此单元格已被访问过。
 * 搜索下一单元格： 计算当前元素的 下、右 两个方向元素的数位和，并开启下层递归 。
 * 回溯返回值： 返回 1 + 右方搜索的可达解总数 + 下方搜索的可达解总数，代表从本单元格递归搜索的可达解总数。
 */
public class movingCount {
    boolean[][] visited;

    public int movingCountSolution(int m, int n, int k) {
        this.visited = new boolean[m][n];
        return dfs(this.visited, m, n, 0, 0, k);
    }

    int dfs(boolean[][] visited, int m, int n, int i, int j, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]
                || (bitSum(i) + bitSum(j)) > k) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(visited, m, n, i + 1, j, k) + dfs(visited, m, n, i, j + 1, k);
    }

    int bitSum(int i) {
        int res = 0;
        while (i > 0) {
            res += i % 10;
            i = i / 10;
        }
        return res;
    }
}
