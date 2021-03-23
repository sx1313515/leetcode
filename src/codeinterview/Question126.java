package codeinterview;

import java.util.Scanner;

/**
 * 描述:
 * 给定一个字符串str，判断是不是整体有效的括号字符串(整体有效：即存在一种括号匹配方案，使每个括号字符均能找到对应的反向括号，且字符串中不包含非括号字符)。
 * @Author: xiang_song
 * @CreateDate: 2021/3/21 3:24 下午
 */
public class Question126 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '(') {
                count ++;
            } else {
                count--;
                if (count < 0) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println(count == 0 ? "YES" : "NO");
    }
}
