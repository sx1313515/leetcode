package leetcode101;

/**
 * 描述:给定一个正整数，求其最少可以由几个完全平方数相加构成
 * 完全平方数
 * 其中 dp[i] 表示数字 i 最少可以由几个完全平方数相加
 * 构成。在本题中，位置 i 只依赖 i - k^2 的位置，如 i - 1、i - 4、i - 9 等等，才能满足完全平方分割
 * 的条件。因此 dp[i] 可以取的最小值即为 1 + min(dp[i-1], dp[i-4], dp[i-9] · · · )。
 * @Author: xiang_song
 * @CreateDate: 2021/3/23 15:15
 */
public class Q279 {
    public int numSquares(int n) {
        int[] num = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= sqrt; j++) {
                min = Math.min(1 + num[i - j * j],min);
            }
            num[i] = min;
        }
        return num[n];
    }
}
