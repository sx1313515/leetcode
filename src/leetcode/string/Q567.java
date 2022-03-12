package leetcode.string;

import java.util.Arrays;

/**
 * 描述: 字符串的排列
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * @Author: xiang_song
 * @CreateDate: 2022/3/9 22:10
 */
public class Q567 {

    public boolean checkInclusion(String s1, String s2) {
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        if(s1.length() > s2.length()) {
            return false;
        }
        for(int i = 0;i < s1.length();i++) {
            // 统计s1的字符出现次数
            a1[s1.charAt(i) - 'a']++;
            // 统计s2的字符出现次数
            a2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(a1, a2)) {
            return true;
        }
        // 滑动窗口
        for(int j = s1.length();j < s2.length();j++) {
            // 被移走了要--
            a2[s2.charAt(j - s1.length()) - 'a']--;
            // 新加的要++
            a2[s2.charAt(j) - 'a']++;
            // 每次都对比一下是否相同，这个可以优化的
            if (Arrays.equals(a1, a2)) {
                return true;
            }
        }
        return false;
    }
}
