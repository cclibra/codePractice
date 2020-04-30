package leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目描述：
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * 思路：
 * 与leetcode112类似，不同的是这里要记录下每条和为sum的路径
 * 仍然选用前序遍历，使用两个变量存储最后结果和本次路径的temp
 * 遍历时注意，传参会复制到递归的下一层，可解决该变量的分支问题
 */
public class leetcode113_pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        helper(root, sum, res, temp);
        return res;
    }

    private void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp) {
        if (root == null)
            return;
        temp.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(temp));
        }
        helper(root.left, sum, res, temp);
        helper(root.right, sum, res, temp);
        temp.remove(temp.size() - 1);
    }
}
