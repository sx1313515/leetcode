package leetcode101;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 描述:给定一个字符串和一个字符串集合，求是否存在一种分割方式，使得原字符串分割后的子字
 * 符串都可以在集合内找到。
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/23 16:54
 */
public class Q139 {
    /**
     * dp[i]表示0....i的字符串是否在字典内，如果前面存在某个位置dp[j]在字典内，且j...i也在字典内，那么dp[i]也在字典内
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordDictSet = new HashSet(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                        //其实substring也是o(n)的时间复杂度，所以总的是o(n^3)
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
    }
}
