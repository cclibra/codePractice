package leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述：
 * 二叉树最大宽度
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。
 * 这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 * <p>
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * <p>
 * 示例 3:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * /
 * 5
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * <p>
 * 思路：
 * 需要先遍历树，可使用BFS或DFS，给每个节点一个 position 值，
 * 如果我们走向左子树，那么 position -> position * 2，
 * 如果我们走向右子树，那么 position -> positon * 2 + 1。
 * 当我们在看同一层深度的位置值 L 和 R 的时候，宽度就是 R - L + 1。
 */
public class leetcode662_widthOfBinaryTree {
    int ans = 0;
    Map<Integer, Integer> left = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        dfsPosition(root, 0, 0);
        return ans;
    }

    private void dfsPosition(TreeNode root, int pos, int depth) {
        if (root == null) return;
        if (!left.containsKey(depth)) {
            left.put(depth, pos);
        }
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfsPosition(root.left, 2 * pos, depth + 1);
        dfsPosition(root.right, 2 * pos + 1, depth + 1);

    }
}
