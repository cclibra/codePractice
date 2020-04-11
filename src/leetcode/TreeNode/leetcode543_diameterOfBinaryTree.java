package leetcode.TreeNode;

/**
 * 题目描述：
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 * 例如：给定二叉树
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * <p>
 * 思路：一个以root为头的树上，最大距离只可能来自以下三种情况：
 * root的左子树上的最大距离。
 * root的右子树上的最大距离。
 * 经过根节点的最长距离，即root左子树上离root.left最远的距离+1(root)+root右子树上离root.right最远的距离。
 * 采用后向遍历，递归调用距离函数。设置全局变量maxDepth作为最终结果，这里使用全局变量是为了避免两次遍历
 * 每次递归均返回当前结点处左右子树的最大深度，然后根据该结果计算上一层节点处的最大距离，即全局变量maxDepth
 * 递归到根节点后，此时maxDepth就是最终结果值
 */
public class leetcode543_diameterOfBinaryTree {
    int maxDepth = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDepth;
    }

    private int depth(TreeNode node) {
        if (node == null)
            return 0;
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        maxDepth = Math.max(leftDepth + rightDepth, maxDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
