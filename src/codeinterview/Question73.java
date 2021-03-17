package codeinterview;

import java.util.Scanner;

/**
 * 描述:回文数
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/13 10:46 上午
 */
public class Question73 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        char[] chars = next.toCharArray();
        int left = chars[0] == '-' ? 1 : 0;
        int length = chars.length;
        int right = length -1;
        if ((left == 0 && length == 1) || (left == 1 && length == 2)){
            System.out.println("YES");
            return;
        }
        while (left <= right) {
            if (chars[left] == chars[right]) {
                left ++;
                right--;
            }else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }
}
