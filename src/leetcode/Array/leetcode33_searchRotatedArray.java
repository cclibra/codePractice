package leetcode.Array;

/**
 * 题目描述：搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。在传递给函数之前，
 * nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2]
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，
 * 如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 思路：
 * 根据提供的时间复杂度，可想到使用二分法。
 * 首先用二分法找到最大的值，然后再判断目标值是在最大值左侧还是右侧，
 * 然后再具体某侧进行二分法查找。
 */
public class leetcode33_searchRotatedArray {
    public static void main(String[] args) {
        int[] nums = {8, 9, 2, 3, 4};
        int res = new leetcode33_searchRotatedArray().search(nums, 9);
        System.out.println(res);
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int peakIndex = findPeakIndex(nums);
        if (nums[0] <= target && nums[peakIndex] >= target) {
            return binarySearch(nums, 0, peakIndex, target);
        } else {
            return binarySearch(nums, peakIndex + 1, nums.length - 1, target);
        }
    }

    public static int findPeakIndex(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] < nums[nums.length - 1]) return nums.length - 1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) return mid;
            else if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    public static int binarySearch(int[] nums, int left, int right, int target) {
        if (nums == null || nums.length == 0) return -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
