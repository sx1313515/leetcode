package leetcode.string;

/**
 * 描述:验证回文字符串 Ⅱ
 *给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * @Author: xiang_song
 * @CreateDate: 2022/3/10 6:17 下午
 */
public class Q680 {
    /**
     * 以"abdda"这个串为例，此时i指向’b’，j指向’d’，发现不对了。
     * 但是有一次删除的机会，我们自己写几个case其实就能发现，
     * 此时子串范围为(i+1, j)或(i, j-1)的俩子串只要有任意一个是回文串，则结果就是回文串，否则就不是。
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int low = 0;
        int hight = s.length() - 1;
        while (low < hight) {
            // 如果不相等，则看下往右移一个或往左移一个可不可以
            if (s.charAt(low) != s.charAt(hight)) {
                return isValid(s, low + 1, hight) || isValid(s, low, hight - 1);
            }
            low++;
            hight--;
        }
        return true;
    }

    /**
     * 判断s的i到j这一段是否是回文串
     * @param s
     * @param i
     * @param j
     * @return
     */
    private boolean isValid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
