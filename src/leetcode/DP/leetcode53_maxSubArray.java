package leetcode.DP;

/**
 * 题目描述：
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 思路：
 * 动态规划，创造dp[i]数组，代表以nums[i]结尾的连续子数组中最大和。
 * 注意，这里每个dp[i]必须包括nums[i]，目的是保证递推的正确性。
 * 构造传递函数 dp[i] = nums[i] + Math.max(dp[i-1], 0)，dp[0]=nums[0]。
 * 这里dp[i-1]若是负值，说明本身对dp[i]产生负贡献，则dp[i]只取nums[i]
 * 最终求dp[i]的最大值max
 * 进一步的可以使用常数优化空间使用。dp[i-1]和max可以使用常数代替
 */
public class leetcode53_maxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = nums[0];
        int pre = 0;
        int cur;
        for (int num : nums) {
            cur = pre < 0 ? num : num + pre;
            pre = cur;
            res = Math.max(cur, res);
        }
        return res;
    }
}
