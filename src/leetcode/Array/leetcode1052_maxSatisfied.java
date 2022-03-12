package leetcode.Array;

/**
 * 题目描述：
 * 有一个书店老板，他的书店开了n分钟。
 * 每分钟都有一些顾客进入这家商店。
 * 给定一个长度为 n 的整数数组 customers ，其中customers[i]是在第 i 分钟开始时进入商店的顾客的编号，
 * 所有这些顾客在第 i 分钟结束后离开。
 * 在某些时候，书店老板会生气。
 * 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 * 当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续minutes分钟不生气，但却只能使用一次。
 * 请你返回这一天营业下来，最多有多少客户能够感到满意。
 * <p>
 * 思路：使用双指针，逐个minutes区间去比较。
 * 可以先算出第一个区间不生气时总的满意度，之后移动区间窗口时，
 * 只要计算右指针增加的跟左指针减少的两个值变动后总的满意度为多少，
 * 逐个区间判断取最大值即可。
 */
public class leetcode1052_maxSatisfied {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        if (customers == null || grumpy == null || customers.length != grumpy.length || minutes > customers.length)
            return 0;
        int n = customers.length, sum = 0;
        for (int i = 0; i < n; i++) {
            if (i < minutes) {
                sum += customers[i];
            } else {
                sum += grumpy[i] == 0 ? customers[i] : 0;
            }
        }
        int left = 0, right = minutes;
        int res = sum;
        while (right < n) {
            if (grumpy[right] == 1) {
                sum += customers[right];
            }
            if (grumpy[left] == 1) {
                sum -= customers[left];
            }
            res = Math.max(res, sum);
            right++;
            left++;
        }
        return res;
    }
}
