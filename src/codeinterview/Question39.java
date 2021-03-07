package codeinterview;

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
public class Question39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            max += nums[i] > 0 ? 1: 0;
        }

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= max && nums[i] != i+1 && nums[nums[i] - 1] != i) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                System.out.println(i+1);
                return;
            }
        }
        System.out.println(n+1);
    }
}
