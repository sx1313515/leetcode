package codeinterview;

import java.util.Scanner;
import java.util.Stack;

/**
 * 最长正数连续子数组
 * 未排序正数数组中累加和为给定值的最长子数组的长度
 */
public class Question8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (n == 1 && a[0] == k){
            System.out.println(1);
            return;
        }
        int left = 0,right = 1;
        int length = 0,sum = a[0] + a[1];
        while (left < n && right < n) {
            if(sum == k) {
                length = Math.max(length,right-left + 1);
                left ++;
                right ++;
                if(right < n){
                    sum = sum - a[left-1] + a[right];
                }
            }else if(sum < k){
                right ++;
                if(right < n){
                    sum = sum + a[right];
                }
            }else{
                left++;
                sum = sum - a[left-1];
            }
        }
        System.out.println(length);
    }

}