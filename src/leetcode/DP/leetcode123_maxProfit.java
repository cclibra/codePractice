package leetcode.DP;

/**
 * 题目描述：
 * 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * PS：本题的区别在于最多可交易2次。
 * <p>
 * 思路：1.可在leetcode121交易一次算法的基础上，将prices数组分成两部分，对每部分分别求最大利润。
 * 分界线可看成隔板，遍历得到。但时间复杂度为O(n^2).
 * 2
 */
public class leetcode123_maxProfit {
    public int maxProfitIII(int[] prices) {
        int n = prices.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int leftProfit = getProfit(prices, 0, i);
            int rightProfit = getProfit(prices, i, n);
            res = Math.max(res, leftProfit + rightProfit);
        }
        return res;
    }


    /**
     * 获取【left，right) 区间内一次交易的最大利润
     *
     * @param prices 价格数组
     * @param left   左边界
     * @param right  右边界
     * @return 最大利润
     */
    public int getProfit(int[] prices, int left, int right) {
        if (left > right || right > prices.length) return 0;
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = left; i < right; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
