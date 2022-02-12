package leetcode.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述：
 * 给你一个整数数组 nums 和一个整数 k ，
 * 请你统计并返回该数组中和为 k 的连续子数组的个数。
 * <p>
 * 思路：
 * 连续子数组可考虑前缀和数组prefixSum，prefixSum[j+1] - prefixSum[i] 代表num[i]~num[j]的子数组和。
 * 可两重循环去遍历，时间复杂度O(n^2)，可以使用哈希表存储已经存在的前缀和和出现次数，时间复杂度为O(n)
 */
public class leetcode560_subarraySum {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            if (map.containsKey(prefixSum[i] - k)) {
                res += map.get(prefixSum[i] - k);
            }
            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
        }
        return res;
    }

}
