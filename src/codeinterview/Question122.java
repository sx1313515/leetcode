package codeinterview;

import java.util.Scanner;

/**
 * 描述:
 * 数组中两个字符串的最小距离
 * 给定一个字符串数组strs，再给定两个字符串str1和str2，返回在strs中str1和str2的最小距离，如果str1或str2为null，或不在strs中，返回-1
 *
 * 数组中两个字符串的最小距离
 * @Author: xiang_song
 * @CreateDate: 2021/3/21 7:41 上午
 */
public class Question122 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str1 = sc.next();
        String str2 = sc.next();
        String[] strs = new String[n];
        if (n < 2 || str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            System.out.println(-1);
            return;
        }
        boolean hasstr1 = false;
        boolean hasstr2 = false;
        int indexstr1 = 0;
        int indexstr2 = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
            if (strs[i].equals(str1)) {
                hasstr1 = true;
                indexstr1 = i;
                if (hasstr2) {
                    min = Math.min(Math.abs(indexstr1 - indexstr2),min);
                }
            }
            if (strs[i].equals(str2)) {
                hasstr2 = true;
                indexstr2 = i;
                if (hasstr1) {
                    min = Math.min(Math.abs(indexstr1 - indexstr2),min);
                }
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
