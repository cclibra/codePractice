package leetcode.Array;

/**
 * 题目描述：
 * 编写一个高效的算法来搜索m×n矩阵 matrix 中的一个目标值 target 。
 * 该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例1：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * <p>
 * 示例2：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 */
public class leetcode240_searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix.length - 1;
        //这里要注意判断j和i的顺序，j要放在前面。
        // 因为如果matrix为空，j不满足直接跳出，不会判断matrix[0],不会造成数组越界
        while (j >= 0 && i < matrix[0].length) {
            if (matrix[j][i] > target) {
                j--;
            } else if (matrix[j][i] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
