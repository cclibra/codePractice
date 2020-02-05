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
 * 后序遍历无法直接判断是否是左右子树，
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

    //迭代
    public List<Integer> postorderTraversal2(TreeNode root) {
        int left = 1;//辅助栈里表示左节点
        int right = 2;//辅助栈里表示右节点
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();//辅助栈
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                stack2.push(left);
                root = root.left;
            }
            while (!stack.isEmpty() && stack2.peek() == right) {
                //如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack2.pop();
                res.add(stack.pop().val);
            }
            if (!stack.isEmpty() && stack2.peek() == left) {
                //如果是从左子节点返回父节点，则将标记改为右子节点
                stack2.pop();
                stack2.push(right);
                root = stack.peek().right;
            }
        }
        return res;
    }
}
