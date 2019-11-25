package leetcode.Stack;

import java.util.LinkedList;

/**
 * 题目描述：
 *  * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *  * 返回滑动窗口中的最大值。
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7],数组长度为n, 和 k = 3
 * 输出: [3,3,5,5,6,7]，长度为 n - k + 1
 * 解释:
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *  思路：
 *  暴力求解的时间复杂度为O(n*k)，不可取，应保证在线性时间复杂度内完成
 *  本题关键在于利用双端队列来实现窗口最大值更新，使用双向队列的目的是，既能够从队尾压入或弹出新数据，又能从队首弹出旧的值。
 *  首先生成双端队列qmax，其中存放数组arr中的下标，然后遍历arr
 *  *如果qmax是空的，就直接放入当前的位置。
 *  *如果qmax不是空的，qmax队尾的位置所代表的值如果不比当前的值大，将一直弹出队尾的位置，
 *   直到qmax队尾的位置所代表的值比当前值大，当前的位置才放入qmax的队尾。
 *  保证每次队首的值为该次窗口的最大值。
 *
 */
public class leetcode239_maxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums,int k){
        if(nums == null||k < 1||nums.length<k){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for(int i = 0;i < nums.length; i++){
            while(!qmax.isEmpty()&&nums[qmax.peekLast()]<nums[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            //该滑窗往下进行后，前面超出该滑窗的索引应该及时弹出，否则计算最大值时就会包括进去
            if(qmax.peekFirst() == i-k){
                qmax.pollFirst();
            }
            if(i >= k - 1){
                res[index++] = nums[qmax.peekFirst()];
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] input = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = new int[input.length - k + 1];
        res = maxSlidingWindow(input,k);
        for(int i:res){
            System.out.print(i);
        }

    }
}
