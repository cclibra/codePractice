package leetcode.TreeNode;

import java.util.HashMap;

/**
 * 题目描述：
 * 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 思路：
 * 前序遍历中，最左边的值就是根节点，然后在中序遍历中根据该根节点找到索引位置。
 * 该位置的左边和右边分别为根节点左子树和右子树的中序遍历。
 * 然后继续对左右子树递归分析
 * 注意要确定左右子树的前序和中序数组的边界位置。
 */
public class leetcode105_buildTreeromPosIn {
    public TreeNode buildTreeFromPosIn(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, indexMap);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
                            HashMap<Integer, Integer> indexMap) {
        //递归终止条件
        if (preStart > preEnd)
            return null;
        TreeNode head = new TreeNode(preorder[preStart]);
        int index = indexMap.get(preorder[preStart]);
        //左子树的前序中序数组边界确定，前序数组起始位置为preStart+1，数组长度与左子树的中序数组长度相同，均为index - inStart
        //因此，前序数组的结束位置为preStart + index - inStart。中序数组起始和结束位置容易理解
        head.left = helper(preorder, preStart + 1, preStart + index - inStart,
                inorder, inStart, index - 1, indexMap);
        //右子树的前序数组就是在左子树前序数组结束位置+1
        head.right = helper(preorder, preStart + index - inStart + 1, preEnd,
                inorder, index + 1, inEnd, indexMap);
        return head;
    }
}
