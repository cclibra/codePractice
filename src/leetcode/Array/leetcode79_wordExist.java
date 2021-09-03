package leetcode.Array;

/**
 * 题目描述：
 * 给定一个m x n 二维字符网格board 和一个字符串单词word。
 * 如果word 存在于网格中，返回 true ；否则，返回 false。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例 1：
 * 输入：board = [["A","B","C","E"],
 * ["S","F","C","S"],
 * ["A","D","E","E"]],
 * word = "ABCCED"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：board = [["A","B","C","E"],
 * ["S","F","C","S"],
 * ["A","D","E","E"]],
 * word = "ABCB"
 * 输出：false
 * <p>
 * 思路：本问题是典型的矩阵搜索问题，可使用 深度优先搜索（DFS）+ 剪枝解决。
 * 深度优先搜索：可以理解为暴力法遍历矩阵中所有字符串可能性。
 * DFS 通过递归，先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推。
 * 剪枝：在搜索中，遇到 这条路不可能和目标字符串匹配成功的情况（例如：此矩阵元素和目标字符不同、此元素已被访问），则应立即返回，称之为 可行性剪枝 。
 */
public class leetcode79_wordExist {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) return false;
        char[] wordChar = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, wordChar, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != word[k]) return false;
        if (k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i, j + 1, k + 1)
                || dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }
}
