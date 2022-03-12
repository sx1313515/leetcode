package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:计数二进制子串
 * 给定一个字符串 s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。
 * 重复出现（不同位置）的子串也要统计它们出现的次数。
 *
 * @Author: xiang_song
 * @CreateDate: 2022/3/1 6:32 下午
 */
public class Q696 {
    /**
     * 先统计连续的0和1分别有多少个，如：111100011000，得到4323；在4323中的任意相邻两个数字，取小的一个加起来，就是3+2+2 = 7.
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        // 统计0个1的连续个数
        char[] chars = s.toCharArray();
        if (chars.length <= 1) {
            return 0;
        }
        char cur = chars[0];
        int total = 1;
        List<Integer> countList = new ArrayList<>();
        int i = 1;
        while (i < chars.length) {
            if (cur == chars[i]) {
                total++;
            } else {
                countList.add(total);
                cur = chars[i];
                total = 1;
            }
            i++;
        }
        countList.add(total);
        // 统计相邻两个数字最小的
        int sum = 0;
        for (int j = 1; j < countList.size(); j++) {
            sum += Math.min(countList.get(j), countList.get(j - 1));
        }
        return sum;
    }
}
