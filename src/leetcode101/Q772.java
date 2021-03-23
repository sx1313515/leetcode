package leetcode101;

import java.util.Scanner;
import java.util.Stack;
import java.util.UnknownFormatConversionException;

/**
 * 描述:
 * 公式字符串求值
 * 给定一个字符串str，str表示一个公式，公式里可以有整数，加减乘除和左右括号，返回公式的计算结果（注意：题目中所有运算都是整型运算，向下取整,且保证数据合法，不会出现除0等情况）。
 * 输入
 * 48*((70-65)-43)+8*1
 * 输出
 * -1816
 * 整数除法仅保留整数部分
 * @Author: xiang_song
 * @CreateDate: 2021/3/17 19:07
 */
public class Q772 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(new Q772().calculate(str));
    }
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int index = 0;
        while(index < chars.length) {
            char ch = chars[index];
            //处理括号问题
            if (ch == '(') {
                int count = 1;
                index ++;
                StringBuilder temp = new StringBuilder();
                while (index < chars.length) {
                    if (chars[index] == '(') {
                        count++;
                        temp.append('(');
                    } else if (chars[index] == ')') {
                        count--;
                        if (count == 0) {
                            index++;
                            break;
                        } else {
                            temp.append(')');
                        }
                    } else {
                        temp.append(chars[index]);
                    }
                    index++;
                }
                int calculate = calculate(temp.toString());
                sb.append(calculate);
            }
            ch = chars[index = index == chars.length ? index - 1 : index];
            if ((!Character.isDigit(ch) && ch != ' ') || index == chars.length-1 || index == chars.length) {  //最后是数组也有入栈
                if (index == chars.length - 1 && ch != ' ') {
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
            index++;
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;

    }
}
