package leetcode.array;

import java.util.HashSet;
/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2021/4/26 16:29
 */
public class Q1128 {
    public static void main(String[] args) {
        new Q1128().numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}});
    }
    public int numEquivDominoPairs(int[][] dominoes) {
        HashSet<String> set = new HashSet<>();
        int count = 0;
        int length = dominoes.length;
        for (int i = 0; i < length; i++) {
            String s1 = dominoes[i][0] + "_" + dominoes[i][1];
            String s2 = dominoes[i][1] + "_" + dominoes[i][0];
            if (set.contains(s1)) {
                count++;
                set.remove(s1);
            } else if (set.contains(s2)) {
                count++;
                set.remove(s2);
            } else {
                set.add(s1);
            }
        }
        return count;
    }
}
