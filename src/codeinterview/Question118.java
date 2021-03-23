package codeinterview;

import java.util.Scanner;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/20 9:49 下午
 */
public class Question118 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int num = n/2;
        int temp = a[0];
        for (int i = 0; i < n; i = i+2) {
            a[i] = a[i/2 + num];
            int middle = a[i/2 + 1];
            a[i+1] = temp;
            temp = middle;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
