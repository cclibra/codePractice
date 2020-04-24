package leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目描述：
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * 思路：BSF，同层次遍历思路类似，但在上下层要各层变换前后顺序
 * 可以使用标志位，每层转换值，也可记录层数，根据奇偶层分别处理
 */
public class leetcode103_zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                if (flag) {
                    temp.add(cur.val);
                } else {
                    temp.add(0, cur.val);
                }
                if (cur.right != null)
                    queue.add(cur.right);
                if (cur.left != null)
                    queue.add(cur.left);
            }
            flag = flag ? false : true;
            res.add(temp);
        }
        return res;
    }
}
