package othercode.TreeNode;

import leetcode.TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目描述：
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 思路：同样是广度优先遍历，增加了对相邻层顺序的变换。
 */
public class treeNodelevelOrderII {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            //这里使用LinkedList作为双端队列
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                //这里使用标志位，利用双端队列的前后插入特性，对最后添加到res的结果进行顺序变换
                if (flag) {
                    tmp.addLast(cur.val);
                } else {
                    tmp.addFirst(cur.val);
                }
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            flag = !flag;
            res.add(tmp);
        }
        return res;
    }
}
