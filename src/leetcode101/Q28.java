package leetcode101;

import java.util.Scanner;

/**
 * 描述:判断子串的位置
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/18 9:34
 */
public class Q28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(new Q28().strStr(str1,str2));
    }
    public int strStr(String haystack, String needle) {
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        if (length1 < length2) {
            return -1;
        }
        if (length2 == 0) {
            return 0;
        }
        for (int i = 0; i < length1; i++) {
            if (chars1[i] == chars2[0]) {
                int index1 = i;
                int index2 = 0;
                while (index1 < length1 && index2 < length2 && chars1[index1] == chars2[index2]) {
                    index1++;
                    index2++;
                }
                if (index2 == length2) {
                    return i;
                }
            }
        }
        return -1;
    }
}
