package leetcode.Array;

/**
 * 题目描述：颜色分类
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，
 * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 */
public class leetcode75_sortColors {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int zero = -1;
        int two = nums.length;
        int i = 0;
        while(i < two){
            if(nums[i] == 1){
                i++;
            }
            if(nums[i] == 2){
                two--;
                swap(nums, i, two);
            }
            else {
                zero++;
                swap(nums, i, zero);
            }
        }

    }
    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
