package leetcode.TreeNode;

/**
 * 题目描述：
 * 给定一个二叉树，计算整个树的坡度。
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * 整个树的坡度就是其所有节点的坡度之和。
 * 示例:
 * 输入:
 * 1
 * /   \
 * 2     3
 * 输出: 1
 * 解释:
 * 结点的坡度 2 : 0
 * 结点的坡度 3 : 0
 * 结点的坡度 1 : |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 * 注意:
 * 任何子树的结点的和不会超过32位整数的范围。
 * 坡度的值不会超过32位整数的范围。
 * <p>
 * 思路：后向遍历，递归返回每个节点的左右节点和，然后使用全局变量存储该节点处的坡度
 * 思路类似于leetcode543计算二叉树直径长度
 */
public class leetcode563_findTilt {
    int sumTilt = 0;

    public int findTilt(TreeNode root) {
        calTilt(root);
        return sumTilt;
    }

    private int calTilt(TreeNode root) {
        if (root == null)
            return 0;
        int leftTilt = calTilt(root.left);
        int rightTilt = calTilt(root.right);
        sumTilt += Math.abs(leftTilt - rightTilt);
        return leftTilt + rightTilt + root.val;
    }
}
