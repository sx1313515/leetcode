package codeinterview;

import java.util.Scanner;
import java.util.Stack;

/**
 * 给定一个整型矩阵 map，其中的值只有 0 和 1 两种，求其中全是 1 的所有矩形区域中，最大的矩形区域里 1 的数量。
 * 求最大子矩阵的大小
 */
public class Question16 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        if (n == 1) {
            System.out.println(fun(a[0]));
            return;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) {
                    a[i][j] = a[i - 1][j] + 1;
                } else {
                    a[i][j] = 0;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, fun(a[i]));
        }
        System.out.println(max);


    }
    public static int fun(int[] heights) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int left = i,right = i;
            while (left > 0 && heights[left - 1] >= heights[i] ){
                left--;
            }
            while (right < heights.length-1 && heights[right + 1] >= heights[i] ){
                right++;
            }
            max = Math.max(max, heights[i] * (right - left + 1));
        }
        return max;
    }
}