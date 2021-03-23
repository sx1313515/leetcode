package dynamicplanning;

import java.util.Stack;

/**
 * 括号字符串的最长有效长度
 * 给定一个括号字符串str，返回最长的能够完全正确匹配括号字符字串的长度。
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 */
public class LongestValidParentheses {
    /**
    * @Description:   思路：加入辅助数组，左括号直接进栈，辅助数组对应编号置0，
     * 右括号进看前面是否有配对，有左括号配对将前面的左括号出栈，
     * 将当前右和左括号在辅助数组中对应位置置1，最后看连续的1的最大数返回。
    * @Author:         xiang_song
    * @CreateDate:     2018/12/27 19:44
    */
    public static int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<length;i++){
            if(chars[i]=='('){
                chars[i]='0';
                stack.push(i);
            }else {
                if(stack.isEmpty()){
                    chars[i]='0';
                    continue;
                }
                else {
                    int left = stack.pop();
                    chars[left]='1';
                    chars[i] = '1';
                }
            }
        }
        int max=0,count=0;
        for(int i=0;i<length;i++){
            if(chars[i]=='0'){
                count=0;
            }else{
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()())"));
    }
}
