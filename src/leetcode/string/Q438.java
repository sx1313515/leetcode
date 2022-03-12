package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述: 找到字符串中所有字母异位词
   给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
   异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * @Author: xiang_song
 * @CreateDate: 2022/3/9 22:10
 */
public class Q438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resList = new ArrayList<>();
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        if(p.length() > s.length()) {
            return resList;
        }
        for(int i = 0; i < p.length();i++) {
            // 统计s2的字符出现次数
            a1[p.charAt(i) - 'a']++;
            // 统计s2的字符出现次数
            a2[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(a1, a2)) {
            resList.add(0);
        }
        // 滑动窗口
        for(int j = p.length();j < s.length();j++) {
            // 被移走了要--
            a2[s.charAt(j - p.length()) - 'a']--;
            // 新加的要++
            a2[s.charAt(j) - 'a']++;
            // 每次都对比一下是否相同，这个可以优化的
            if (Arrays.equals(a1, a2)) {
                resList.add(j - p.length() + 1);
            }
        }
        return resList;
    }

    public static void main(String[] args) {

    }
}
