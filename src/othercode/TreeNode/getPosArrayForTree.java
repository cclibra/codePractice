package othercode.TreeNode;

import java.util.HashMap;

/**
 * 题目描述：
 * 已知一棵二叉树所有的节点值都不同，给定这棵树正确的先序和中序数组，
 * 不要重建整棵树，而是通过这两个数组直接生成正确的后序数组。
 * 思路：
 * 根据当前的先序和中序数组，设置后序数组最右边的值，
 * 然后划分出左子树的先序、中序数组，以及右子树的先序、中序数组，
 * 先根据右子树的划分设置好后序数组，再根据左子树的划分，从右边到左边依次设置好后序数组的全部位置。注意左右子树的顺序
 */
public class getPosArrayForTree {
    private int[] getPosArray(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length)
            return null;
        int len = pre.length;
        int[] pos = new int[len];
        HashMap<Integer, Integer> map = new HashMap<>();//建立中序的数值和索引的对应关系(题目已经说明所有节点值不同)
        for (int i = 0; i < len; i++) {
            map.put(in[i], i);
        }
        setPos(pre, 0, len - 1, in, 0, len - 1, pos, len - 1, map);
        return pos;
    }

    //递归调用setPos，pos为后序遍历数组，返回值setLoc是往pos里填放的下一个位置
    private int setPos(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd,
                       int[] pos, int setLoc, HashMap<Integer, Integer> map) {
        if (preStart > preEnd) return setLoc;
        pos[setLoc--] = pre[preStart];//先序的根节点,放置完后位置前移
        int pivot = map.get(pre[preStart]);//这里是为了能根据先序的根节点找到该值在中序数组中的位置，从而切分
        //根节点右边对应的，右子树先序遍历数组的长度和中序遍历数组长度相同
        setLoc = setPos(pre, preEnd - inEnd + pivot + 1, preEnd, in, pivot + 1, inEnd, pos, setLoc, map);
        //根节点左边对应的
        return setPos(pre, preStart, preStart + pivot - inStart, in, inStart, pivot - 1, pos, setLoc, map);
    }
}
