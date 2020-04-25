package leetcode.TreeNode;

/**
 * 题目描述：
 * 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * <p>
 * 思路：
 * 有序数组可以看作是结果二叉树的中序遍历结果
 * 而且中序遍历结果求二叉树结果不唯一
 * 由于要求是高度平衡二叉树BST
 * 因此有几种方法：
 * 1.始终选择中间位置左边元素作为根节点
 * 2.始终选择中间位置右边元素作为根节点
 * 3.选择任意一个中间位置元素作为根节点
 * 选择一种方法递归的建立树节点
 */
public class leetcode108_sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;//中间节点位置，偶数长度则为左边
        //if ((left + right) % 2 == 1) ++p; //选择中间位置右边节点则要加上本句
        //if ((left + right) % 2 == 1) p += rand.nextInt(2);//随机选择加上本句
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

}
