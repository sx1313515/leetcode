package leetcode101;

/**
 * 描述:有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 * @Author: xiang_song
 * @CreateDate: 2022/2/28 6:50 下午
 */
public class Q242 {
    public boolean isAnagram(String s, String t) {
        if (t.length() != s.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int[] count = new int[26];
        for (int i = 0; i < chars1.length; i++) {
            count[chars1[i] - 'a'] += 1;
            count[chars2[i] - 'a'] -= 1;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
