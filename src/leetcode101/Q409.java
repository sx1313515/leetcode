package leetcode101;

/**
 * 描述:最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * @Author: xiang_song
 * @CreateDate: 2021/4/16 9:58
 */
public class Q409 {
//    这题其实是构造性的题目，所以只需要尽可能的左右对称地构造字符串就行了，所以回文串里每种字符都出现了偶数次，除了奇数长度的回文串的时候最中间的那个字符可以出现奇数次。
//    比如回文串 abba，每个字符都出现了偶数次。而奇数长度的回文串abcbcbcba，c出现了奇数次。
    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        char[] memo = new char[128];
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (memo[chars[i]] == '1') {
                memo[chars[i]] = '0';
                count = count + 2;
            } else {
                memo[chars[i]] = '1';
            }
        }
        if (count < length) {
            count ++;
        }
        return count;
    }
}
