package leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目描述：
 * 给定一个二叉树，返回它的 后序 遍历。
 * 通过递归和迭代两种方式实现。
 * 迭代方法中，区别于之前 94 题 中序遍历和 144 题 先序遍历，后序遍历的非递归形式会相对难一些。
 * 原因就是，当遍历完某个根节点的左子树，回到根节点的时候，对于中序遍历和先序遍历可以把当前根节点从栈里弹出，然后转到右子树。
 */
public class leetcode145_postorderTraversal {
    //递归
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        postorder(root, res);
        return res;
    }

    private void postorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

}
