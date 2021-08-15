package othercode.Array;

/**
 * 题目描述：
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * 思路：
 * 使用二分法，对数组中的元素和该元素对应的索引进行比较。根据条件将数组分成两个子数组，
 * 分别为左子数组： nums[i] = i ；
 * 右子数组： nums[i] != i
 * 缺失的数字等于 “右子数组的首位元素” 对应的索引；
 * 因此考虑使用二分法查找 “右子数组的首位元素” 。
 */
public class missingNumber {
    public int missingNumberSolution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int mid;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
