package codeinterview;

import java.util.Scanner;

/**
 * 描述:给定两个字符串str1和str2，输出连个字符串的最长公共子序列。如过最长公共子序列为空，则输出-1。
 * 最长公共子序列
 * @Author: xiang_song
 * @CreateDate: 2021/2/28 2:54 下午
 */
public class Question31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int length1 = s1.length();
        int length2 = s2.length();
        int[][] memo = new int[length1 + 1][length2 + 2];
        StringBuilder sb = new StringBuilder();
        for (int i =1;i<=length1;i++){
            for (int j = 1; j <=length2; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        if (memo[length1][length2] == 0) {
            System.out.println(-1);
        } else {
            while (length1 > 0 && length2 > 0) {
                if (memo[length1][length2] == memo[length1][length2-1]) {
                    length2--;
                } else if (memo[length1][length2] == memo[length1-1][length2]){
                    length1--;
                } else {
                    sb.append(chars1[length1 - 1]);
                    length1--;
                    length2--;
                    if (sb.length() == memo[s1.length()][s2.length()]) {
                        break;
                    }
                }
            }
        }
        System.out.println(sb.reverse().toString());


    }
}
