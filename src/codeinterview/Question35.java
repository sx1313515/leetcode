package codeinterview;

import java.util.Scanner;

/**
 * 描述:不包含本位置值的累乘数组
 * 给定一个数组arr，返回不包含本位置值的累乘数组
 * 例如，arr=[2,3,1,4]，返回[12, 8, 24, 6]，即除自己外，其他位置上的累乘
 * [要求]
 * 时间复杂度为O(n)O(n)，额外空间复杂度为O(1)O(1)
 * @Author: xiang_song
 * @CreateDate: 2021/3/3 9:27 下午
 */
public class Question35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[] nums = new int[n];
        long[] res = new long[n];
        long temp = 1;
        for (int i = 0; i < n; i ++) {
            nums[i] = sc.nextInt();
            res[i] = (int)temp;
            temp *= nums[i];
            temp %= p;
        }
        temp = 1;
        for (int i = n - 1; i >= 0; i --) {
            res[i] *= temp;
            res[i] %= p;
            temp *= nums[i];
            temp %= p;
        }
        for (long x: res) {
            System.out.print(x + " ");
        }
    }
}
