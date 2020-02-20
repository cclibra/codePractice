package leetcode.TreeNode;

/**
 * 题目描述：
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 题目思路：
 * 使用递归，解法的整体过程像是二叉树后序遍历，对任何一个节点head来说，先遍历head的左子树，遍历过程中，传递两个值，
 * 该左子树是否为平衡二叉树，左子树的高度。这里若发现左子树不是平衡二叉树，可直接跳出。
 * 若是平衡二叉树，同样遍历右子树。若左右子树同为平衡二叉树，则判断左右子树高度差是否大于1，若大于1则不是平衡二叉树。
 * 若不大于1，则返回左右子树中较大的一个。
 * 这里level可在传入参数时+1，也可在最后返回较大值时+1
 */
public class leetcode110_isBalanced {
    public Boolean isBalanced(TreeNode head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];
    }

    private int getHeight(TreeNode head, int level, boolean[] res) {
        if (head == null)
            return level;
        int leftHeight = getHeight(head.left, level + 1, res);
        if (!res[0]) return level;
        int rightHeight = getHeight(head.right, level + 1, res);
        if (!res[0]) return level;
        if (Math.abs(leftHeight - rightHeight) > 1) res[0] = false;
        return Math.max(leftHeight, rightHeight);
    }

    //简洁版，这里不维持布尔变量，仅在迭代中维持该子树的高度，一旦非平衡，则返回-1。
    public Boolean isBalanced2(TreeNode head) {
        return getHeight2(head) == -1;
    }

    private int getHeight2(TreeNode head) {
        if (head == null) return 0;
        int left = getHeight2(head.left);
        if (left == -1) return -1;
        int right = getHeight2(head.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
