package leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述:分糖果
 *
 * @Author: xiang_song
 * @CreateDate: 2021/4/26 14:39
 */
public class Q575 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < candyType.length; i++) {
            set.add(candyType[i]);
        }
        if (set.size() >= candyType.length / 2) {
            return candyType.length / 2;
        } else {
            return set.size();
        }
    }
}
