package codeinterview;

import sun.security.util.Length;

import java.util.Arrays;
import java.util.Scanner;

/**
 求最短通路值
 题目描述
 用一个整形矩阵matrix表示一个网格，1代表有路，0代表无路，每一个位置只要不越界，都有上下左右四个方向，求从最左上角到右下角的最短通路值
 例如，matrix为：
 1 0 1 1 1
 1 0 1 0 1
 1 1 1 0 1
 0 0 0 0 1
 通路只有一条，由12个1构成，所以返回12
 [要求]
 时间复杂度为O(nm)O(nm)，空间复杂度为O(nm)O(nm)
 */
public class Question38 {
    static int[][] memo;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        max = n*m+1;
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        memo = new int[n][m];
        for (int[] me : memo) {
            Arrays.fill(me,-1);
        }
        boolean[][] flags = new boolean[n][m];
        flags[0][0] = true;
        int fun = 1+Math.min(fun(nums, n, m, flags, 0, 1),fun(nums, n, m, flags, 1, 0));
        System.out.println(fun >= max ? -1 : fun);
    }

    private static int fun(int[][] nums, int n, int m, boolean[][] flags, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || nums[i][j] == 0 || flags[i][j]) { //越界了，直接返回最大指
            return max;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        flags[i][j] = true;
        int min = min(1 + fun(nums, n, m, flags, i-1, j),
                1 + fun(nums, n, m, flags, i+1, j),
                1 + fun(nums, n, m, flags, i, j-1),
                1 + fun(nums, n, m, flags, i, j+1));
        memo[i][j] = min;
        flags[i][j] = false;
        return min;



    }

    private static int min(int up, int down, int left, int right) {
        int min = Math.min(up, down);
        min = Math.min(min, left);
        min = Math.min(min, right);
        return min;
    }
}
