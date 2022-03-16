package leetcode.DP;

/**
 * 题目描述：
 * 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第i个元素prices[i] 表示一支给定股票第i天的价格。
 * 你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 思路：
 * DP思想，第i天的最大收益=要么i天当天不交易，为第i-1天最大收益；
 * 要么第i天交易，此时最大收益为i价格与前i-1天最小价格的差值。
 * 需要维护前i-1天最小值和前i天的最大收益
 */
public class letcode121_maxProfit {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
