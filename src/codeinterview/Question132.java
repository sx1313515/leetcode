package codeinterview;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 描述:找到指定类型的新类型字符
 * 新类型字符的定义如下:
 *       1.新类型字符是长度为1或者2的字符串。
 *       2. 表现形式可以仅是小写字母，例如，"e"; 也可以是大写字母+小写字母，例如，"Ab";还可以是大写字母+大写字母，例如，"DC"。
 *       现在给定一个字符串str, str 一定是若干新类型字符 正确组合的结果。比如"eaCCBi"，由新类型字符"e"、"a”、"CC"和"Bi"拼成。 再给定一个整数k，代表str中的位置。请返回第k个位置的新类型字符。
 * @Author: xiang_song
 * @CreateDate: 2021/3/20 4:34 下午
 */
public class Question132 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String str = sc.next();
        char[] chars = str.toCharArray();
        int i = 0;
        while (i < chars.length) {
            if (Character.isLowerCase(chars[i])) {  //小写字母
                if (i == k) {
                    System.out.println(chars[i]);
                    return;
                }
                i++;
            } else {
                if (i == k || i + 1 == k) {
                    System.out.println(new char[] {chars[i],chars[i+1]});
                    return;
                }
                i = i +2;
            }
        }
    }
}
