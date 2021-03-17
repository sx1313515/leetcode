package codeinterview;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *容器盛水问题
 */
public class Question54 {
    private static HashMap<String,Integer> memo = new HashMap<>(16);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        if (n <= 2) {
            System.out.println(0);
            return;
        }
        int sum = 0;
        for (int i = 1; i < n - 1; i++) {
            int left = -1;
            int right = -1;
            for (int j = 0; j < i; j++) {
                left = Math.max(left, a[j]);
            }
            for (int k = i+1; k < n; k++) {
                right = Math.max(right, a[k]);
            }
            sum = sum + (Math.min(left, right) > a[i] ? (Math.min(left, right) - a[i]) : 0);
        }
        System.out.println(sum);


    }
}
