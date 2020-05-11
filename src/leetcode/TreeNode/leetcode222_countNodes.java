package leetcode.TreeNode;

/**
 * 题目描述：
 * 给出一个完全二叉树，求出该树的节点个数。
 * 说明：
 * 完全二叉树的定义如下：
 * 在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。
 * 最底层为第 h 层，则该层包含 1~ 2^h 个节点。
 * 思路：
 * 1.通用的计算节点方法，递归到每个节点访问，访问完成时返回一次计数，逐层叠加。
 * 没有用到完全二叉树的特性，时间复杂度为O(logN)。
 * 2.首先，满二叉树的节点数N和树高度的关系为N=2^h-1，所以可以先判断左右子树的高度，加上根节点为2^h
 * 如果两边高度相等，由于节点首先填满左边位置，则说明左子树已经被填满，节点数可以算出，则递归判断右子树节点数。
 * 如果两边高度不等，则说明左子树还没填满，右子树最后一层还没有填，倒数第二层是填满的，则递归判断左子树节点数。
 */
public class leetcode222_countNodes {
    private int countNodes1(TreeNode root) {
        if (root == null)
            return 0;
        return countNodes1(root.left) + countNodes1(root.right) + 1;
    }

    private int countNodes2(TreeNode root) {
        if (root == null)
            return 0;
        int res = 0;
        int leftHeight = countHeight(root.left);
        int rightHeight = countHeight(root.right);
        if (leftHeight == rightHeight) {
            res += countNodes2(root.right) + (1 << leftHeight);
        } else {
            res += countNodes2(root.left) + (1 << rightHeight);
        }
        return res;
    }

    private int countHeight(TreeNode root) {
        if (root == null)
            return 0;
        return countHeight(root.left) + 1;
    }
}
