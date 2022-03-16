package leetcode.DP;

/**
 * 题目描述：
 * 买卖股票的最佳时机 II
 * 给定一个数组 prices ，其中prices[i]表示股票第 i 天的价格。
 * 在每一天，你可能会决定购买和/或出售股票。你在任何时候最多只能持有一股股票。
 * 你也可以购买它，然后在 同一天 售。
 * 返回 你能获得的 最大 利润。
 * PS：本题的区别在于不设交易次数。
 * 思路：可使用通用的DP思想，也可直接使用贪心。因为本题不设交易次数，则只要本日比前日上涨则进行交易。累计求和即可
 */
public class leetcode122_maxProfit {
    public int maxProfitII(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                res += prices[i + 1] - prices[i];
            }
        }
        return res;
    }
}
