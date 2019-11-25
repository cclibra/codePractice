package leetcode;

/*
题目描述：
给出一个未排序的整数数组，找出最长递增子序列的长度。

输入： [10,9,2,5,3,7,101,18]
输出：4
说明：最长递增子序列为[2,3,7,101]，长度为4，可能有多个可能的最长递增子序列，此题只需要返回长度即可。

注意，此处递增子序列不连续！！
 */
public class leetcode300_lengthOfLIS {
    public static void main(String[] args) {
        int[] input = {10,9,2,5,3,7,1,18};
        int res = getLengthOfLIS1(input);
        System.out.println(res);
    }
    //方法一：动态规划
    public static int getLengthOfLIS(int[] input){
        if(input==null||input.length<1)
            return 0;
        int len = input.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int res = 1;
        for(int i = 1;i<len;i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(input[i]>input[j])
                    dp[i] = dp[i] > dp[j + 1] ? dp[i] : dp[j + 1];
                if(res<dp[i])
                    res = dp[i];
            }
        }
        return res;
    }
    //方法二：动态规划+二分法
    public static int getLengthOfLIS1(int[] input){
        if(input==null||input.length<1)
            return 0;
        int[] help = new int[input.length];
        int res = 0;
        for(int num:input){
            int left = 0,right = res;
            while(left < right){
                int mid = (left + right)/2;
                if(help[mid]<num)
                    left = mid + 1;
                else
                    right = mid;
            }
            help[right] = num;
            if(res == right)
                res++;
        }
        return res;
    }
}
