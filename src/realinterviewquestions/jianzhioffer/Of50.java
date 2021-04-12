package realinterviewquestions.jianzhioffer;

/**
 * 描述: 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * @Author: xiang_song
 * @CreateDate: 2021/4/1 8:48
 */
public class Of50 {
    public static void main(String[] args) {
        System.out.println((char) 97);
    }
    public char firstUniqChar(String s) {
        int[] memo = new int[127];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            memo[chars[i]] = memo[chars[i]] + 1;
        }
        for (int i = 0; i < chars.length; i++) {
            if (memo[chars[i]] == 1) {
                return chars[i];
            }
        }
        return ' ';
    }
}
