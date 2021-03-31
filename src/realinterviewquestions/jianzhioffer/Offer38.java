package realinterviewquestions.jianzhioffer;

import java.util.HashSet;

/**
 * 描述:排列
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/30 10:16 下午
 */
public class Offer38 {
    public static void main(String[] args) {
        String[] abcs = new Offer38().permutation("abc");
        for (String abc :
                abcs) {
            System.out.println(abc);
        }
    }
    private HashSet<String> result = new HashSet<>();
    private boolean[] userd;
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        userd = new boolean[length];
        StringBuilder sb = new StringBuilder();
        dfs(chars,0,sb,length);
        return result.toArray(new String[]{});
    }

    private void dfs(char[] chars, int i, StringBuilder sb,int length) {
        if (i == length) {  //满足一个结果了
            result.add(sb.toString());
            return; //推出进入到回溯
        }
        for (int j = 0; j < length; j++) { //取每一个数都会全部遍历一遍，通过userd数组来记录，这样就不用remove和add了
            if (!userd[j]) { //这个元素没用过
                userd[j] = true;
                sb.append(chars[j]);
                //递归
                dfs(chars,i+1,sb,length);  //i+1是表示当前字符串的长度追加1，sb得传进去
                //回溯
                sb.deleteCharAt(sb.length() - 1);
                userd[j] = false;
            }

        }
    }

}
