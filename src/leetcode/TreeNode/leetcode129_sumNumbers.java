package leetcode.TreeNode;

/**
 * 题目描述：
 * 求根到叶子节点数字之和。
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 思路：
 * 使用全局变量存储最后结果。对二叉树使用深度优先遍历，然后需要解决向下传递时位数变高的问题。
 * 这里选择在递归函数参数中加入cur,作为当前节点处的暂时数字之和，然后传到下一层时要增大10倍，
 * 等到叶子节点时就可以作为一个路径数字和，加入到最终结果中
 * 递归函数的入参每次调用都会给该参数开辟空间，可以利用这一点在每层中传递参数值
 */
public class leetcode129_sumNumbers {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        dfsSearchTree(root, 0);
        return sum;
    }

    private void dfsSearchTree(TreeNode root, int cur) {
        if (root.left == null && root.right == null) sum += cur;
        if (root.left != null) dfsSearchTree(root.left, cur * 10);
        if (root.right != null) dfsSearchTree(root.right, cur * 10);
    }

}
