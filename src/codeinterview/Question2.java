package codeinterview;

import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i = 0;i < n;i++) {
                a[i] = sc.nextInt();
            }
            if(n == 1 || n == 0) {
                System.out.println(n);
                return;
            }
            int len = 0;
            int max = 0;
            int min = 0;
            HashSet<Integer> set = new HashSet<Integer>(); // 判断重复
            for (int i = 0; i < a.length; i++) {
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                for (int j = i; j < a.length; j++) {
                    if (set.contains(a[j])) {
                        break;
                    }
                    set.add(a[j]);
                    max = Math.max(max, a[j]);
                    min = Math.min(min, a[j]);
                    if (max - min == j - i) { // 新的检查方式
                        len = Math.max(len, j - i + 1);
                    } }
                set.clear();
            }
            System.out.println(len);
        }
    }
}