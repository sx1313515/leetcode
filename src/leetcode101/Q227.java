package leetcode101;

import java.util.Stack;

/**
 * 描述:
 *给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分
 * @Author: xiang_song
 * @CreateDate: 2021/3/17 19:07
 */
public class Q227 {
    public static void main(String[] args) {
        System.out.println(new Q227().calculate("3+2*2"));
    }
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        char sign = '+';

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if ((!Character.isDigit(ch) && ch != ' ') || i == chars.length-1) {  //最后是数组也有入栈
                if (i == chars.length - 1 && ch != ' ') {
                    sb.append(ch);
                }
                if(sign == '+') {
                    stack.add(Integer.parseInt(sb.toString()));
                } else if(sign == '-') {
                    stack.add(Integer.parseInt(sb.toString())*-1);
                } else if(sign == '*') {
                    stack.add(Integer.parseInt(sb.toString())*stack.pop());
                } else {
                    stack.add(stack.pop()/Integer.parseInt(sb.toString()));
                }
                sb.setLength(0);
                sign = ch;
            } else if (Character.isDigit(ch)) {
                sb.append(ch);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;

    }
}
