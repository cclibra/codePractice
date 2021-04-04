package leetcode.DP;

/**
 * 题目描述：
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 解题思路：
 * 在leetcode198的基础上，增加了 围成一圈 的条件。
 * 相当于分成了三种情况：要么首尾都不被抢，要么只抢第一家，要么只抢最后一家。
 * 由于首尾都不被抢并没有收益，所以只选择后两种。
 * 因此，在之前基础上，增加后两种的判断。
 */
public class leetcode213_rob {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int N = nums.length;
        //注意这里要对单个值进行判断
        if (N == 1) return nums[0];
        return Math.max(robRange(nums, 0, N - 2),
                robRange(nums, 1, N - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int N = nums.length;
        int temp = 0, temp_1 = 0, temp_2 = 0;
        for (int i = end; i >= start; i--) {
            temp = Math.max(nums[i] + temp_2, temp_1);
            temp_2 = temp_1;
            temp_1 = temp;
        }
        return temp;
    }

}
