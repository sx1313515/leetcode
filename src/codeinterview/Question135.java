package codeinterview;

import java.util.Scanner;

/**
 * 描述:回文最少分割
 * 给定一个字符串，返回把str全部切割成回文串的最少切割数。
 * 本题是一个经典的动态规划的题目。定义动态规划数组 dp，dp[i]的含义是子串 str[i..len-1]
 * 至少需要切割几次，才能把 str[i..len-1]全部切成回文子串。那么，dp[0]就是最后的结果。
 * @Author: xiang_song
 * @CreateDate: 2021/3/23 9:29 下午
 */
public class Question135 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
        int length = str.length();
        if (length == 1) {
            System.out.println(0);;
            return;
        }
        if (length == 2) {
            System.out.println(chars[0] == chars[1] ? 0 : 1);
            return;
        }
        boolean[][] values = new boolean[length][length];   //values[i][j]表示从i到j是否为回文串
        for(int i=0;i<length;i++){  //初始化一字母回文串，每个字母都是长度为一的回文串
            values[i][i]=true;
        }
        for(int i=1;i<length;i++){  //初始化二字母回文串，两个相同连续的字母是长度为二的回文串
            if(chars[i]==chars[i-1]){
                values[i-1][i]=true;
            }
        }
        for (int i = 2; i < length; i++) {  //长度为3，4,5，，，，，i是否是回文串
            for (int j = 0; j < length-i; j++) {
                if(chars[j]==chars[j+i]&&values[j+1][j+i-1]==true){
                    values[j][j+i] = true;
                }
            }
        }
        int[] memo = new int[length];
        for (int i = length - 2; i >= 0; i--) {
            memo[i] = 1 + memo[i + 1];  //如果跟右边所有的元素都不互为回文串，则分割1+下一个回文串的次数
            for (int j = i + 1; j < length; j++) {
                if (values[i][j]) {
                    memo[i] = j == length -1 ? 0 : Math.min(memo[i], 1 + memo[j+1]);  //如果j是最右边的元素，说明不需要分割了
                }
            }
        }
        System.out.println(memo[0]);
    }


}
