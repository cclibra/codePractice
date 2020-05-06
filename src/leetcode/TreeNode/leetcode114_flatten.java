package leetcode.TreeNode;

/**
 * 题目描述：
 * 给定一个二叉树，原地将它展开为链表。
 * 例如，给定二叉树
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * 思路：
 * 展开的顺序起始就是先序遍历，然后通过右节点连接起来
 * 1.可以顺序将节点的左子树放到右边，然后将右子树整个放到左子树最右边的节点，完成该节点的转移
 * 然后考虑新的右节点，重复上一过程，直至结束
 * 2.该顺序可以看作为先序遍历倒置，即修改的后序遍历，先右节点再左节点根节点
 * 然后将每个节点以此与逆序遍历的下个节点相连。此处要用全局变量pre保存上一次遍历的节点，然后该次遍历的节点右侧与pre相连
 */
public class leetcode114_flatten {
    public void flatten1(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
                continue;
            }
            TreeNode temp = root.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = root.right;
            root.right = root.left;
            root.left = null;
            root = root.right;
        }
    }

    private TreeNode pre = null;

    public void flatten2(TreeNode root) {
        if (root == null)
            return;
        flatten2(root.right);
        flatten2(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

}
