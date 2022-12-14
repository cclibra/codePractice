package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述：插入区间
 * 给你一个无重叠的，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 示例：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 *
 */
public class leetcode57_insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        //无交集
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        //有交集
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(new int[]{newInterval[0], newInterval[1]});
        //剩余无交集
        while (i < intervals.length) {
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        int[][] res = new int[list.size()][2];
        for (i = 0; i < list.size(); i++){
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }
}
