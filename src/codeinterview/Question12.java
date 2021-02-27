package codeinterview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 换钱的最少货币数
 */
public class Question12 {
    private static int[] a;
    private static int[] memo;
    private static int max;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        max = k+1;
        memo = new int[k + 1];
        Arrays.fill(memo,-1);
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int result = fun(k);
        if (result >= k) {
            System.out.println(-1);
        }else {
            System.out.println(result);
        }
    }
    public static int fun(int k) {
        if (memo[k] != -1) {
            return memo[k];
        }
        if (k == 0){
            return 0;
        }
        if (k < 0) {
            return max+1;
        }
        int[] temps = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            temps[i] = k-a[i] >= 0 ? fun(k - a[i])+1 : max;
        }
        int min = min(temps);
        memo[k] = min;
        return min;
    }

    public static int min(int[] a) {
        int min = a[0];
        for(int i =0;i<a.length;i++){
            min = Math.min(min, a[i]);
        }
        return min;
    }
}