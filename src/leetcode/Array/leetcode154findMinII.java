package leetcode.Array;

/**
 * 题目描述：
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
 * 例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]]旋转一次的结果为
 * 数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * <p>
 * 给你一个可能存在重复元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。
 * 请你找出并返回数组中的最小元素 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,5]
 * 输出：1
 * 示例 2：
 * 输入：nums = [2,2,2,0,1]
 * 输出：0
 * <p>
 * 思路：
 * 旋转排序数组 numsnums 可以被拆分为 2 个排序数组 nums1nums1 , nums2nums2 ，
 * 并且 nums1任一元素 >= nums2任一元素；
 * 因此，考虑二分法寻找此两数组的分界点 nums[i]nums[i] (即第 2 个数组的首个元素)。
 * 设置 left, right 指针在 numsnums 数组两端，midmid 为每次二分的中点：
 * 当 nums[mid] > nums[right]时，mid 一定在第 1 个排序数组中，i一定满足 mid < i <= right，因此执行 left = mid + 1；
 * 当 nums[mid] < nums[right] 时，mid 一定在第 2 个排序数组中，i一定满足 left < i <= mid，因此执行 right = mid；
 * 当 nums[mid] == nums[right] 时，是此题对比 153题 的难点（原因是此题中数组的元素可重复，难以判断分界点 i 指针区间）；
 * 我们采用 right = right - 1 解决此问题，证明：
 * 此操作不会使数组越界：因为迭代条件保证了 right > left >= 0；
 * 此操作不会使最小值丢失：假设 nums[right]nums[right] 是最小值，有两种情况：
 * 若 nums[right]是唯一最小值：那就不可能满足判断条件 nums[mid] == nums[right]，因为 mid < right（left != right 且 mid = (left + right) // 2 向下取整）；
 * 若 nums[right] 不是唯一最小值，由于 mid < right 而 nums[mid] == nums[right]，即还有最小值存在于 [left, right - 1] 区间，因此不会丢失最小值。
 * 作者：jyd
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/solution/154-find-minimum-in-rotated-sorted-array-ii-by-jyd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class leetcode154findMinII {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length - 1;
        int mid;
        //此处不取等号，因为数组中必有最小值，只剩单个元素时可返回
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
                //注意这里right赋值mid并不是mid - 1，因为这时mid在后面的排序数组中，而且可能为最小值
            else if (nums[mid] < nums[right]) right = mid;
            else right = right - 1;
        }
        return nums[right];
    }
}
