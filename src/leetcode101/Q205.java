package leetcode101;

/**
 * 描述:同构字符串
 *给定两个字符串s和t，判断它们是否是同构的。
 *
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * @Author: xiang_song
 * @CreateDate: 2022/3/1 5:49 下午
 */
public class Q205 {
    /**
     * 判断字符第一次出现的位置是否一样没如果一样则同构
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int[] firstIndexS = new int[300];
        int[] firstIndexT = new int[300];
        for (int i = 0; i < chars.length; i++) {
            // s第一次出现
            if (firstIndexS[chars[i]] == 0) {
                firstIndexS[chars[i]] = i + 1;  // 加1处理第一个字符出现位置是0，则初始数组也是0的情况
            }
            // t第一次出现
            if (firstIndexT[chart[i]] == 0) {
                firstIndexT[chart[i]] = i + 1;  // 加1处理第一个字符出现位置是0，则初始数组也是0的情况
            }
            if (firstIndexS[chars[i]] != firstIndexT[chart[i]]) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        new Q205().isIsomorphic("ab", "aa");
    }
}
