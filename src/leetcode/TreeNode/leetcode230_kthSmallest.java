package leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 题目描述：
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * 思路：
 * 可以使用中序遍历，得到根据节点值升序的数组，然后找到第 k个最小元素。如果使用递归需要遍历整个树。
 * 使用迭代可以在遍历到结果时停止，不用遍历整个树。
 */
public class leetcode230_kthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return 0;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                if (--k == 0) break;
                root = root.right;
            }
        }
        return root.val;
    }
}
