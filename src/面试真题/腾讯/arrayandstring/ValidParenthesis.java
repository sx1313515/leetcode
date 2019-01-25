package 面试真题.腾讯.arrayandstring;

import java.util.HashMap;
import java.util.Stack;

/**
 * 描述:
 *给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * @Author: xiang_song
 * @CreateDate: 2019/1/22 17:37
 */
public class ValidParenthesis {
    public boolean isValid(String s) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');hashMap.put(')', '(');hashMap.put('[', ']');
        hashMap.put(']', '[');hashMap.put('{', '}');hashMap.put('}', '{');
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='('||chars[i]=='{'||chars[i]=='['){
                stack.add(chars[i]);
            }else {
                if(stack.empty()){
                    return false;
                }else {
                    if(hashMap.get(stack.pop())!=chars[i])
                        return false;
                }
            }
        }
        if (stack.size()>0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParenthesis().isValid("()"));;
    }
}
