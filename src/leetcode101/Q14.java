package leetcode101;

/**
 * 描述:最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @Author: xiang_song
 * @CreateDate: 2021/4/16 8:43
 */
public class Q14 {
    //    当字符串数组长度为 0 时则公共前缀为空，直接返回
    //    令最长公共前缀 ans 的值为第一个字符串，进行初始化
    //    遍历后面的字符串，依次将其与 ans 进行比较，两两找出公共前缀，最终结果即为最长公共前缀
    //    如果查找过程中出现了 ans 为空的情况，则公共前缀不存在直接返回
    //    时间复杂度：O(s)O(s)，s 为所有字符串的长度之和
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < length; i++) {
            int index = 0;
            int count = 0;
            String str = strs[i];
            while (index < ans.length() && index < str.length()) {
                if (ans.charAt(index) == str.charAt(index)) {
                    count ++;
                    index ++;
                } else {
                    break;
                }
            }
            if (count == 0) {
                return "";
            }
            ans = ans.substring(0, count);
        }
        return ans;
    }
}
