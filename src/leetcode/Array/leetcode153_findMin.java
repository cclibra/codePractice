package leetcode.Array;

/**
 * 题目描述：
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
 * 例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 给你一个元素值 互不相同 的数组 nums ，
 * 它原来是一个升序排列的数组，并按上述情形进行了多次旋转。
 * 请你找出并返回数组中的 最小元素 。
 * 设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 思路：看到O(log n)可想到二分法。
 * 这里可认为前段数组升序排列（前段数组长度可为0），从某个元素开始为最小值，然后继续升序排列。
 * 这里注意，可以用nums[0]作为分界线，大于nums[0]的为前半段，小于nums[0]的为后半段。
 * 利用该值作为比较进行二分。
 */
public class leetcode153_findMin {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int k = nums[0];
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(Math.min(nums[left], nums[right]), k);
    }
}
