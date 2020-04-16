package leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目描述：
 * 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。（即逐层地，从左到右访问所有节点）。
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * 思路：
 * 按照层序遍历，其实就是广度优先遍历bsf，使用队列进行遍历节点存储
 * 针对每一层，需要记录该次队列中的长度，以确定放入该轮次list中数值的数量
 * 因此，只有在某节点的左右子节点不为空的情况下，才会向队列中放入值
 */
public class leetcode102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
            res.add(temp);
        }
        return res;
    }
}
