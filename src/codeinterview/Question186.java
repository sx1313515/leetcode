package codeinterview;

import java.util.Scanner;

/**
 * 描述:矩阵的最小路径和
 * 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
 * @Author: xiang_song
 * @CreateDate: 2021/3/27 10:13 下午
 */
public class Question186 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        int[][] memo = new int[n][m];
        memo[0][0] = nums[0][0];
        for (int i = 1; i < m; i++) {
            memo[0][i] = nums[0][i] + memo[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            memo[i][0] = nums[i][0] + memo[i-1][0];
        }
        if (n == 1) {
            System.out.println(memo[0][m-1]);
            return;
        }
        if (m == 1) {
            System.out.println(memo[n-1][0]);
            return;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                memo[i][j] = Math.min(memo[i - 1][j], memo[i][j - 1]) + nums[i][j];
            }
        }
        System.out.println(memo[n-1][m-1]);
    }
}
