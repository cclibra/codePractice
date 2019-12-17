package othercode.Stack;

import java.util.Stack;

/**
 * 题目描述：
 * 给定一个不含有重复值的数组 arr，找到每一个i位置左边和右边离i位置最近且值比arr[i]小的位置。返回所有位置相应的信息。
 * -----------------------
 * 示例：
 * 输入
 * arr = {3 4 1 5 6 2 7}
 * 输出二维数组
 * -1 2
 * 0 2
 * -1 -1
 * 2 5
 * 3 5
 * 2 -1
 * 5 -1
 * 其中-1表示不存在
 * -----------------------
 * 解题思路：
 * 如果使用暴力遍历，在每个位置分别向左和向右遍历查找，则时间复杂度为O(N^2)，太高。
 * 关键在于生成所有位置的相应信息，这里使用单调栈结构，时间复杂度做到O(N)。
 * 首先，准备一个栈，栈中放的元素是数组的位置。由于是找某位置左右边距离最近且比该值小的位置，那么要保证栈底到栈顶严格递增。
 *
 * 分为两个阶段: 完整遍历一遍数组; 接着进行清算阶段。
 *
 * 遍历数组阶段:
 * *栈为空时，直接压栈。
 * *如果当前元素大于栈顶索引对应的值, 则将当前元素的索引压栈。
 * *如果当前元素小于栈顶索引对应的值, 弹出栈顶索引, 此时能得到被弹出的索引左右两侧比它小并且离它最近的值的索引, 具体地：
 * **当前元素的索引就是该索引右侧的最终结果
 * **如果栈为空, 则该索引左侧没有元素了, 可以令左侧的结果为-1
 * **如果栈不为空, 那新的栈顶索引就是该索引左侧的最终结果
 *
 * 清算阶段: 清算阶段的所有元素都没有右侧元素
 * *如果栈不为空, 弹出栈顶索引, 该索引没有右侧结果, 可以令右侧结果为-1;
 *  如果此时栈不为空, 那么该元素的左侧结果就是新栈顶索引;
 *  如果此时栈为空, 该索引没有左侧结果, 可以令左侧结果为-1
 * */
public class monotoneStack {
    public static int[][] getNearLessNoRepeat(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < arr.length;i++){
            while(!stack.isEmpty()&&arr[i]<arr[stack.peek()]){
                int popIndex = stack.pop();
                res[popIndex][0] = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int popIndex = stack.pop();
            res[popIndex][0] = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][1] = -1;
        }
        return res;
    }
    public static void main(String[] args){
        int[] arr = {3,4,1,5,6,2,7};
        int[][] res = getNearLessNoRepeat(arr);
        for(int[] temp1:res){
            for(int temp2:temp1){
                System.out.print(temp2+",");
            }
            System.out.println(" ");
        }
    }

}
