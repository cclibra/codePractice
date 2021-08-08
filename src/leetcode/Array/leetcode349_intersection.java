package leetcode.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目描述：
 * 给定两个数组， 编写一个函数来计算它们的交集。
 * 交集中排除掉重复元素
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * 思路：
 * 先进行排序，然后使用双指针逐个扫描递进
 */
public class leetcode349_intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (int tmp : set) {
            res[index++] = tmp;
        }
        return res;
    }
}
