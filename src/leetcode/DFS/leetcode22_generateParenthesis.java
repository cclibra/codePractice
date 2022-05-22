package leetcode.DFS;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目描述：
 * 数字n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 *
 * 思路：
 * dfs，记录当前序列和左括号的数量，只有左括号数量不到n时才可以添加左括号，只有左括号数量比右括号多时在能增加右括号，
 * 只有当前序列长度为2*n时才添加到结果中。注意要在每次递归后弹出最后添加的括号。
 */
public class leetcode22_generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        List<String> cur = new LinkedList<>();
        if (n <= 0) return res;
        return dfs(n, 0, cur, res);
    }

    private List<String> dfs(int n, int leftNum, List<String> cur, List<String> res) {
        if (cur.size() == 2 * n) {
            res.add(String.join("",cur));
        }
        if (leftNum < n) {
            cur.add("(");
            dfs(n, leftNum + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
        if (leftNum > cur.size() - leftNum) {
            cur.add(")");
            dfs(n, leftNum, cur, res);
            cur.remove(cur.size() - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode22_generateParenthesis test = new leetcode22_generateParenthesis();
        List<String> res = test.generateParenthesis(3);
        System.out.println(res.toString());
    }
}
