package dynamicplanning;

/**
 * @ClassName: 最长回文子串
 * @Description: java类作用描述
 * @CreateDate: 2018/12/27 10:50
 */
/*
  思路:
  使用动态规划算法，如果Si到Sj是回文串，且Si-1等于Sj+1。那么Si-1到Sj+1也是回文串
  我们首先初始化一字母和二字母的回文，然后找到所有三字母回文，并依此类推…
 */
public class LongestPalindromicSubstring {
    /**
    * @Description:    o(n^2)
    * @Author:         xiang_song
    * @CreateDate:     2018/12/27 15:54
    */
    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        if(length==1){
            return s;
        }
        if(length==0)
            return null;
        boolean[][] values = new boolean[length][length];   //values[i][j]表示从i到j是否为回文串
        for(int i=0;i<length;i++){  //初始化一字母回文串，每个字母都是长度为一的回文串
            values[i][i]=true;
        }
        int sum = 1;
        int flagx = 1,flagy=1;
        for(int i=1;i<length;i++){  //初始化二字母回文串，两个相同连续的字母是长度为二的回文串
            if(chars[i]==chars[i-1]){
                values[i-1][i]=true;
                sum=2;
                flagx=i-1;
                flagy=i;
            }
        }
        for (int i = 2; i < length; i++) {  //长度为3，4,5，，，，，i是否是回文串
            for (int j = 0; j < length-i; j++) {
                if(chars[j]==chars[j+i]&&values[j+1][j+i-1]==true){
                    values[j][j+i] = true;
                    if(i+1>sum){
                        flagx = j;
                        flagy = j+i;
                        sum = i+1;
                    }
                }
            }
        }
        return s.substring(flagx,flagy+1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abba"));
    }
}
