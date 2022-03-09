package mianshizhenti.teambition;

/**
 * 描述:给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 * 输出:
 * 18
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * @Author: xiang_song
 * @CreateDate: 2019/4/15 17:23
 */
public class SplitArray {
    public int splitArray(int[] nums, int m) {

        int length = nums.length;
        int[] sums = new int[length + 1];  //累加和数组，
        int[][] dp = new int[m+1][length+1];
        for(int i=0;i<=m;i++) {
            for (int j = 0; j <= length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i=1;i<=length;i++){
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= length; ++j) {
                for (int k = i - 1; k < j; ++k) {
                    int val = Math.max(dp[i - 1][k], sums[j] - sums[k]);  //算子数组的最大值
                    dp[i][j] = Math.min(dp[i][j], val);    //去最大值里面最小的那个
                }
            }
        }
        return dp[m][length];
    }

    public static void main(String[] args) {
        new SplitArray().splitArray(new int[]{7, 2, 5, 10, 8},2);
    }
}
