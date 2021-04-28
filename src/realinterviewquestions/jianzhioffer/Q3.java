package realinterviewquestions.jianzhioffer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 描述:无重复字符的最长子串
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/31 9:56
 */
public class Q3 {
    public static void main(String[] args) {
        System.out.println(new Q3().lengthOfLongestSubstring("dvdf"));
    }
    public int lengthOfLongestSubstring(String s) {
        LinkedHashSet<Character> set = new LinkedHashSet<>(); //有序
        char[] chars = s.toCharArray();
        if (chars.length == 0 || chars.length == 1) {
            return chars.length;
        }
        int max = 0;
        int cur = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                cur++;
                max = Math.max(max, cur);
            } else {
                Iterator<Character> iterator = set.iterator();
                while (iterator.hasNext()) {
                    Character next = iterator.next();
                    if (next.equals(chars[i])) {
                        iterator.remove();
                        set.add(chars[i]);
                        break;
                    } else {
                        iterator.remove();
                        cur--;
                        if (cur == 0) {
                            set.add(chars[i]);
                            cur++;
                        }
                    }
                }
            }
        }
        return max;
    }
}
