package leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述：
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 但是 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 思路：
 * 可采用递归和迭代。
 * 递归中，要注意是比较该二叉树左右子树是否对称，终止条件是两对应节点全为空则返回true，一个空或者两个非空但值不等返回false。
 * 返回给上一层的值是当前是否为镜像对称。 该层需要做的是比较左子树和镜像的右子树 以及 右子树和镜像的左子树是否相等。
 * <p>
 * 迭代中，需要用到队列存储，类似于BSF，将树的正像和镜像分别按每层放到队列里，而且每连续的两个是两个树的对应。
 * 队列不为空时就一直循环，若队列弹出相邻的两个值同为空则继续，一个为空或者两个非空但值不等返回false。
 * 值相等时，往队列中添加两个的左右子节点，注意要按照对应镜像的顺序添加。
 */
public class leetcode101_isSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;//空树认为是对称的
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val
                && isMirror(left.left, right.right)
                && isMirror(left.right, right.left));
    }

    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }
}
