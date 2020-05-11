package leetcode.TreeNode;

/**
 * 题目描述：
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。
 * 该路径至少包含一个节点，且不一定经过根节点。
 * 思路：
 * 维护一个全局变量max存储当前的最大和。
 * 使用递归，返回给上个节点当前的最大和。针对当前节点，递归调用方法，获取左子树和右子树的最大和
 * 注意每一层都要包括根节点的值，由根节点才能连接
 */
public class leetcode124_maxPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        dfsHelper(root);
        return max;
    }

    private int dfsHelper(TreeNode root) {
        if (root == null)
            return 0;
        //计算节点左子树的最大和，若为负数则选择0
        int leftMax = Math.max(0, dfsHelper(root.left));
        //计算节点右子树的最大和，若为负数则选择0
        int rightMax = Math.max(0, dfsHelper(root.right));
        //更新max的值，这里将当前节点与左右子树最大和的和与max之前值比较，取较大者
        //这里可以看出max在叶子节点为负时可以被赋于负值，然后在与某个负值节点比较时也可能为负值
        max = Math.max(max, root.val + rightMax + leftMax);
        //注意，这里返回给上一级的是该节点为根的子树的最大和，一定要包括该根的值
        //目的是返回上层包括该节点的路径中的最大值，因为每层更新max时，需要用到当前节点值与从左右子树返回的值
        //要保证连通性，左右子树返回值必须包括左右节点的值
        return root.val + Math.max(leftMax, rightMax);
    }

}
