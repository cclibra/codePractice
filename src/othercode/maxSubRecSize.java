package othercode;

import java.util.Stack;

/**
 * 题目描述：
 * 给定一个整形矩阵map，其中的值只有0和1，找出只包含 1 的区域最大的矩形，并返回其面积。
 *
 * 例如：
 * 1 1 1 0
 * 最大矩形区域有3个1，返回3
 *
 * 再如
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 0
 * 最大矩形区域有6个1，返回6
 *
 * 思路：
 * 1.以矩阵的每一行做分割,统计以当前行作为底的情况下,每个列位置往上的1的数量
 * 构造高度数组height来表示
 * 2.每当得到一个height数组之后都求一次最大矩形面积,再逐行比较
 * 3.通过height数组求面积时,可以理解为是一个高度分别为height值的直方图求最大矩形面积，求直方图中各个柱子最大能扩到多大。
 * 问题转化为柱子左右两边离它最近且比它小的柱子在哪里。该问题可用之前的单调栈解决，详情可见monotoneStack。
 *
 * 若矩形有N行M列，则可做到时间复杂度为O(N*M)
 */
public class maxSubRecSize {
    private static int maxRecSize(int[][] map){
        if(map == null||map.length==0||map[0].length==0){
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for(int i = 0;i < map.length;i++){
            for (int j = 0;j < map[0].length;j++){
                //height数组更新，j位置上每次与该位置之前的值进行比较。
                //注意这里height初始化后初始值为0，故可以统一写为下列方式
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxArea,maxRecFromBottom(height));
        }
        return maxArea;
    }

    private static int maxRecFromBottom(int[] height){
        if(height==null||height.length==0)
            return 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < height.length;i++){
            while(!stack.isEmpty()&&height[i]<=height[stack.peek()]){
                //索引j处左边最近为索引k的值，右边最近为索引i的值,若左边没有比索引j处小的值，可假定此值在数组之外，即“索引-1”处
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1)*height[j];
                maxArea = Math.max(maxArea,curArea);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            //右边没有比索引j处小的值，可假定此值在数组之外，即“索引height.length”处
            int curArea = (height.length - k - 1)*height[j];
            maxArea = Math.max(maxArea,curArea);
        }
        return maxArea;
    }
    public static void main(String[] args){
        int[][] map = {{1,0,1,1},{1,1,1,1},{1,1,1,0}};
        int res = maxRecSize(map);
        System.out.println(res);
    }
}
