package leetcode.TreeNode;

import java.util.HashMap;

/**
 * 题目描述：
 * 从中序与后序遍历序列构造二叉树
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 思路：
 * 中序和后序重构的过程与先序和中序的过程类似。
 * 先序和中序的过程是用先序数组最左的值来对中序数组进行划分，因为这是头节点的值。
 * 中序数组中根节点的值是后序数组最右的值，所以用后序最右的值来划分中序数组即可。
 */
public class leetcode106_buildTreeFromInPos {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null)
            return null;
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return helper(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1, indexMap);
    }

    private TreeNode helper(int[] postorder, int posStart, int posEnd, int[] inorder, int inStart, int inEnd,
                            HashMap<Integer, Integer> indexMap) {
        if (posStart > posEnd)
            return null;
        TreeNode head = new TreeNode(postorder[posEnd]);
        int index = indexMap.get(postorder[posEnd]);
        //左子树的中序数组长度为index-1-inStart，后序数组长度也是相同，起始值为posStart，结束值则是posStart+长度值
        head.left = helper(postorder, posStart, posStart + index - 1 - inStart,
                inorder, inStart, index - 1, indexMap);
        //右子树的后序数组起始值为 左子树后序数组结束值 + 1
        head.right = helper(postorder, posStart + index - inStart, posEnd - 1,
                inorder, index + 1, inEnd, indexMap);
        return head;
    }

}
