package othercode.TreeNode;

import leetcode.TreeNode.TreeNode;

/**
 * 题目描述：
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * <p>
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * <p>
 * 思路：二叉搜索树的中序遍历为 递增序列 。
 * <p>
 * 根据以上性质，易得二叉搜索树的 中序遍历倒序 为 递减序列 。
 * 因此，求 “二叉搜索树第 k 大的节点” 可转化为求 “此树的中序遍历倒序的第 k 个节点”。
 * 为求第 k 个节点，需要实现以下 三项工作 ：
 * 1、递归遍历时计数，统计当前节点的序号；
 * 2、递归到第 k 个节点时，应记录结果 res ；
 * 3、记录结果后，后续的遍历即失去意义，应提前终止（即返回）。
 * <p>
 * 递归解析：
 * 终止条件： 当节点 root为空（越过叶节点），则直接返回；
 * 递归右子树： 即 dfs(root.right)；
 * 三项工作：
 * 提前返回： 若 k = 0 ，代表已找到目标节点，无需继续遍历，因此直接返回；
 * 统计序号： 执行 k = k - 1（即从 k 减至 0 ）；
 * 记录结果： 若 k = 0，代表当前节点为第 kk 大的节点，因此记录 res = root.val ；
 * 递归左子树： 即 dfs(root.left) ；
 */
public class kthLargestFromTree {
    int res = 0;
    int k = 0;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        afterVisit(root);
        return res;
    }

    void afterVisit(TreeNode root) {
        if (root == null || k == 0) return;
        afterVisit(root.right);
        if (--k == 0) {
            res = root.val;
        }
        afterVisit(root.left);
    }
}
