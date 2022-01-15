package leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目描述：
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * 每一种解法包含一个不同的n皇后问题 的棋子放置方案，该方案中 'Q' 和 '.'分别代表了皇后和空位。
 * <p>
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：[["Q"]]
 * <p>
 * 思路：回溯法，从第一行一直到第n行，在每行遍历每一列，判断在该处房放置Q时上面、左上、右上是否已经存在Q，
 * 存在则跳过，不存在可放置。
 */

public class leetcode54_solveNQueens {
    public static void main(String[] args) {
        leetcode54_solveNQueens test = new leetcode54_solveNQueens();
        List<List<String>> res = test.solveNQueens(4);
        for (List<String> tmp : res) {
            System.out.println(tmp.toString());
        }
    }

    List<List<String>> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return null;
        backTrack(new char[n][n], 0);
        return res;
    }

    /**
     * 回溯递归
     *
     * @param board 固定列表，放有已经存在的路径，小于row的行都已经存在Q
     * @param row   遍历的当前行，选择列表
     */
    void backTrack(char[][] board, int row) {
        int n = board.length;
        //结束条件
        if (row == board.length) {
            res.add(transform(board));
            return;
        }
        Arrays.fill(board[row], '.');
        for (int i = 0; i < board[0].length; i++) {
            if (!isValid(board, row, i)) {
                continue;
            }
            board[row][i] = 'Q';
            backTrack(board, row + 1);
            board[row][i] = '.';
        }
    }

    //判断合法性
    boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        //检查上方列
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        //检查左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        //检查右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    //展示转换
    List<String> transform(char[][] board) {
        List<String> list = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        for (char[] chars : board) {
            for (char c : chars) {
                sb.append(c);
            }
            list.add(sb.toString());
            sb.setLength(0);
        }
        return list;
    }
}
