package codeinterview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 描述:
 * 给定一个长度为N(N>1)的整形数组arr, 可以划分成左右两个部分，左部分为arr[0…K]，右部分为arr[K+1…N-1],
 * K可以取值的范围是[0,N-2]。求这么多划分方案中，左部分中的最大值减去右部分最大值的绝对值中，最大是多少
 * [要求]
 * 时间复杂度为O(n), 空间复杂度为O(n)
 * @Author: xiang_song
 * @CreateDate: 2021/3/11 8:49
 */
public class Question63 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] memo = new int[n];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        if (n == 2) {
            System.out.println(Math.abs(a[0]-a[1]));
            return;
        }
        memo[0] = a[0];

        for (int i = 1; i < n; i++) {
            memo[i] = Math.max(a[i], memo[i - 1]);
        }
        int max = a[n-1];
        int result = Math.abs(memo[n-2]-max);
        for (int i = n-2; i > 0; i--) {
            max = Math.max(max,a[i]);
            result = Math.max(result, Math.abs(memo[i-1] - max));
        }
        System.out.println(result);


    }
}
