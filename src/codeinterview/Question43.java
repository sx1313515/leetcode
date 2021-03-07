package codeinterview;

import java.util.Scanner;

/**
 *最小编辑代价
 * 给定两个字符串str1和str2，再给定三个整数ic，dc和rc，分别代表插入、删除和替换一个字符的代价，请输出将str1编辑成str2的最小代价。
 */
public class Question43 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        int insert = sc.nextInt();
        int delete = sc.nextInt();
        int replace = sc.nextInt();
        char[] chars1 = str1.toCharArray();
        int length1 = chars1.length;
        char[] chars2 = str2.toCharArray();
        int length2 = chars2.length;
        int[][] memo = new int[length1+1][length2+1];
        for (int i = 0; i <= length2; i++) {
            memo[0][i] = insert * i;
        }
        for (int i = 0; i <= length1; i++) {
            memo[i][0] = delete * i;
        }
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1];
                } else {
                    memo[i][j] = replace+memo[i - 1][j - 1];
                }
                memo[i][j] = Math.min(memo[i][j], memo[i][j - 1] + insert);
                memo[i][j] = Math.min(memo[i][j], memo[i-1][j] + delete);
            }
        }
        System.out.println(memo[length1][length2]);

    }
}
