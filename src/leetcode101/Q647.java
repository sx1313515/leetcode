package leetcode101;

/**
 * 描述:
 *给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * @Author: xiang_song
 * @CreateDate: 2021/3/17 17:08
 */
public class Q647 {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        if(length==1){
            return 1;
        }
        int sum = 0;
        boolean[][] values = new boolean[length][length];   //values[i][j]表示从i到j是否为回文串
        for(int i=0;i<length;i++){  //初始化一字母回文串，每个字母都是长度为一的回文串
            values[i][i]=true;
            sum++;
        }

        for(int i=1;i<length;i++){  //初始化二字母回文串，两个相同连续的字母是长度为二的回文串
            if(chars[i]==chars[i-1]){
                values[i-1][i]=true;
                sum++;
            }
        }
        for (int i = 2; i < length; i++) {  //长度为3，4,5，，，，，i是否是回文串
            for (int j = 0; j < length-i; j++) {
                if(chars[j]==chars[j+i]&&values[j+1][j+i-1]==true){
                    values[j][j+i] = true;
                    sum++;
                }
            }
        }
        return sum;
    }
}
