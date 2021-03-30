package realinterviewquestions.jianzhioffer;

/**
 * 描述:整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * @Author: xiang_song
 * @CreateDate: 2021/3/29 19:51
 */
public class Q343 {
    public static void main(String[] args) {
        System.out.println(new Q343().cuttingRope(10));
    }
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 1;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, j * Math.max(dp[i - j],i-j));  //i-j可以拆开也可以不拆，取大的
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
