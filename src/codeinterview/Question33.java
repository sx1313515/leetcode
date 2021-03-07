package codeinterview;

import java.util.Scanner;

/**
 * 描述:给定两个字符串str1和str2,输出两个字符串的最长公共子串，如果最长公共子串为空，输出-1。
 * 最长公共子串
 * @Author: xiang_song
 * @CreateDate: 2021/2/28 2:54 下午
 */
public class Question33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int length1 = s1.length();
        int length2 = s2.length();
        int[][] memo = new int[length1 + 1][length2 + 1];
        int max = 0;
        int index = -1;
        for (int i = 1;i<=length1;i++) {
            for (int j = 1;j<=length2;j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                    if (memo[i][j] > max) {
                        max = memo[i][j];
                        index = i - 1;
                    }
                } else {
                    memo[i][j] = 0;
                }
            }
        }
        if (max == 0) {
            System.out.println(-1);
        } else {
            System.out.println(s1.substring(index-max+1,index+1));;
        }
    }

}
