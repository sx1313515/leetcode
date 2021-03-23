package codeinterview;

import java.util.Scanner;

/**
 * 描述:字符串的调整I
 * 给定一个字符串chas[],其中只含有字母字符和“*”字符，现在想把所有“*”全部挪到chas的左边，字母字符移到chas的右边。完成调整函数。
 * @Author: xiang_song
 * @CreateDate: 2021/3/20 5:38 下午
 */
public class Question115 {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    char[] chars = str.toCharArray();
    int firstXing = 0;
    for (int i = chars.length-1; i >= 0; i--) {  //找到第一个*出现的位置
        if (chars[i] == '*') {
            firstXing = i;
            break;
        }
    }
    for (int i = firstXing -1; i >= 0; i--) {
        if (chars[i] != '*') {  //字母
            chars[firstXing] = chars[i];
            chars[i] = '*';
            while (firstXing >= 0) {
                if (chars[firstXing] == '*') {
                    break;
                }
                firstXing--;
            }
        }
    }
    System.out.println(String.valueOf(chars));
}
}
