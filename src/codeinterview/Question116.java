package codeinterview;

import java.util.Scanner;

/**
 *  翻转字符串
 *  给定字符类型的数组chas，请在单词间做逆序调整。只要做到单词的顺序逆序即可，对空格的位置没有要求。
 */
public class Question116 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String str = sc.next();
        char[] chars = str.toCharArray();
        char[] temp = new char[size];
        for(int i=0;i<size;i++){
            temp[i] = chars[i];
        }
        for(int i=size;i<chars.length;i++){
            chars[i-size] = chars[i];
        }
        for(int i = 0;i<size;i++){
            chars[i+chars.length-size] = temp[i];
        }
        System.out.println(String.valueOf(chars));
    }
}
