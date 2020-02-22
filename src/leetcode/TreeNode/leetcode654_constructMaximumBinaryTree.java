package leetcode.TreeNode;

/**
 * 题目描述：
 * 最大二叉树
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * 思路：
 * 递归，先找到数组中的最大值，建立根节点
 * 然后递归的调用，找出该处左边和右边的最大值，分别建立根节点，接到上级节点的左右子节点处
 */
public class leetcode654_constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    private TreeNode construct(int[] nums, int start, int end) {
        if (start == end) return null;
        int maxIndex = start;
        for (int i = start; i < end; i++) {
            if (nums[maxIndex] < nums[i])
                maxIndex = i;
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = construct(nums, start, maxIndex);
        root.right = construct(nums, maxIndex + 1, end);
        return root;
    }
}
