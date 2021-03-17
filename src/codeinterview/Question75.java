package codeinterview;

import java.util.Scanner;

/**
 * 描述:在有序旋转数组中找到一个数
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/13 10:46 上午
 */
public class Question75 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int left = 0;
        int right = n-1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (a[mid]==num) {
                System.out.println("Yes");
                return;
            } else if (num > a[mid]){
                if (a[mid] <= a[right]) {
                    if (num <= a[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    left = mid + 1;
                }
            } else {
                if (a[mid] >= a[left]) {
                    if (num >= a[left]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    right = mid - 1;
                }
            }
        }
        System.out.println("No");
    }
}
