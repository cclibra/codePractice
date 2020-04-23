package leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目描述：
 * 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * 思路：同leetcode102层次遍历思路类似，区别仅为添加到res的顺序不同
 * 这里使用list的add带index方法插到开头
 */
public class leetcode107_levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            res.add(0, temp);
        }
        return res;
    }
}
