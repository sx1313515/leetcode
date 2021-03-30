package leetcode101;

/**
 * 描述:
 *  dp[i]:i个A需要多少次操作，dp[i] = dp[j]+i/j,其中j是i最大的一个除数
 * @Author: xiang_song
 * @CreateDate: 2021/3/23 17:46
 */
public class Q650 {
    public static void main(String[] args) {
    }
    public int minSteps(int n) {
        int[] memo = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = i/2; j >= 1; j--) {
                if (i % j == 0) {
                    memo[i] = i / j+memo[j];
                    break;
                }
            }
        }
        return memo[n];
    }
}
