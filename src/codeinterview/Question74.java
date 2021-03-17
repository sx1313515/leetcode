package codeinterview;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Scanner;

/**
 * 描述:在有序旋转数组中找到最小值
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/13 10:46 上午
 */
public class Question74 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int left = 0;
        int right = n-1;
        while (left < right) {
            if (a[left] <= a[right]) {
                System.out.println(a[left]);
                return;
            }
            if (right - left == 1) {
                System.out.println(Math.min(a[left],a[right]));
                return;
            }
            int mid = (left + right)/2;
            if (a[mid] < a[right]) {
                right = mid;
            } else if (a[mid] > a[right]){
                left = mid;
            } else {
                left = mid;
            }
        }
        System.out.println(a[left]);

    }
}
