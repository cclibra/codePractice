package othercode;

import java.util.LinkedList;

/**
 * 题目描述：
 * 最大值减去最小值小于或等于num的子数组数量
 *
 * 给定数组 arr 和整数 num，共返回有多少个子数组满足如下情况：
 * max(arr[i...j] - min(arr[i...j]) <= num
 * max(arr[i...j])表示子数组arr[i...j]中的最大值，min[arr[i...j])表示子数组arr[i...j]中的最小值。
 *
 * 题目思路：
 * 暴力求解的时间复杂度为O(N^3),不可取，这里可以实现时间复杂度为O(N)的解法。
 * 有两个重要逻辑：
 * 1、如果子数组arr[i,j]满足条件，则arr[i,j]中的每一个子数组都满足条件。
 * 2、如果子数组arr[i,j]不满足条件，则所有包含arr[i,j]的子数组都不满足条件。
 * 这道题目本质上需要计算每个子数组的最大值与最小值的差，判断是否符合要求。
 * 所以需要设计一个快速获得最大值和最小值的方法。由于子数组中的数字下标是连续的，可以考虑队列和栈之类的结构来实现。
 * 参考leetcode239_maxSlidingWindow“生成窗口最大值数组”，可以用双向队列来实现快速获取最大值和最小值。
 *
 * 过程如下：
 * 1.生成两个双端队列max和min，生成两个整型变量i和j，表示子数组范围，利用res记录满足条件的子数组的数量;
 * 2.令j不断右移，不断更新max和min来判断当前子数组是否满足条件。一旦出现arr[i,j]不满足的情况出现，则j停止向右扩的过程，
 *   此时arr[i,j-1]，arr[i,j-2]，……，arr[i,i]一定均满足条件。满足条件的数量为j-i个，于是令res+=j-i；
 * 3.令i右移一个位置，对max和min进行更新，max和min从原来的arr[i,j]窗口更新成arr[i+1,j]窗口的最大值和最小值结构。重复步骤2。
 *   也就是求所有必须以arr[i+1]作为第一个元素的子数组中，满足条件的数量有多少。
 * 4.根据步骤2和3，依次分别求出，必须以a[0],a[1],a[2].....开头的子数组中满足条件的有多少个，全部累加后得到结果。
 *
 * 上述过程中，所有下标值最多进qmax和qmin一次，出一次。i和j的值也不断增加，不减少。整个过程的时间复杂度为O(N)。
 */
public class subArrNum {
    public static int getSubArrNum(int arr[],int num){
        if(arr == null||arr.length == 0||num < 0)
            return 0;
        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();
        int res = 0;
        int i = 0;
        int j =0;
        while(i < arr.length){
            while(j < arr.length){
                while (!qmin.isEmpty() && arr[j] <= arr[qmin.peekLast()]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while (!qmax.isEmpty() && arr[j] >= arr[qmax.peekLast()]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);

                if(arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num)
                    break;
                j++;
            }
            res+= j - i;
            if(qmin.peekFirst() == i){
                qmin.pollFirst();
            }
            if(qmax.peekFirst() == i){
                qmax.pollFirst();
            }
            i++;
        }
        return res;
    }
    public static void main(String[] args){
        int[] arr = {1,2,4,3,2,4,4,5};
        int num = 1;
        int res = getSubArrNum(arr,num);
        System.out.println(res);

    }

}
