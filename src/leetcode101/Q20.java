package leetcode101;

import java.util.Stack;

/**
 * 描述:20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * @Author: xiang_song
 * @CreateDate: 2022/2/28 5:04 下午
 */
public class Q20 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ')' && !stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else if (chars[i] == '}' && !stack.empty() && stack.peek() == '{') {
                stack.pop();
            } else if (chars[i] == ']' && !stack.empty() && stack.peek() == '[') {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        stack.peek();
    }
}
