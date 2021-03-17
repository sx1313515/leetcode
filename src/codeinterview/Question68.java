package codeinterview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 描述:正数数组的最小不可组成和
 * 给定一个正数数组arr，其中所有的值都为整数，以下是最小不可组成和的概念
 * 把arr每个子集内的所有元素加起来会出现很多值，其中最小的记为min，最大的记为max
 * 在区间[min, max]上，如果有数不可以被arr某一个子集相加得到，那么其中最小的那个数是arr的最小不可组成和
 * 在区间[min, max]上，如果所有的数都可以被arr的某一个子集相加得到，那么max+1是arr的最小不可组成和
 * 请写函数返回正数数组arr的最小不可组成和
 * @Author: xiang_song
 * @CreateDate: 2021/3/13 7:31 上午
 */
public class Question68 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
            min = Math.min(min, a[i]);
        }
        int[] result = new int[sum + 1];
        int[][] memo = new int[n][sum + 1];
        for (int i = 1; i < sum + 1; i++) {
            if (i == a[0]) {
                memo[0][i] = 1;
                result[i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            memo[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum ; j++) {
                if (memo[i - 1][j] == 1 || (j - a[i] >= 0 && memo[i - 1][j - a[i]] == 1)) {
                    memo[i][j] =1;
                    result[j] = 1;
                }
            }
        }
        for (int i = min; i <= sum; i++) {
            if (result[i] == 0) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(sum + 1);
    }

}
