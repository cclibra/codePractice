package othercode.TreeNode;

import leetcode.TreeNode.TreeNode;

import java.util.*;

/**
 * 题目描述：
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：
 * <p>
 * [3,9,20,15,7]
 * <p>
 * 思路：广度优先搜索
 */
public class treeNodelevelOrder {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> set = new HashSet<>();
        queue.add(root);
        set.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                list.add(cur.val);
            }
            if (cur.left != null && !set.contains(cur.left)) {
                queue.add(cur.left);
                set.add(cur.left);
            }
            if (cur.right != null && !set.contains(cur.right)) {
                queue.add(cur.right);
                set.add(cur.right);
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (Integer tmp : list) {
            res[i++] = tmp;
        }
        return res;
    }
}
