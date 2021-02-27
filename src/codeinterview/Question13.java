package codeinterview;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 */
public class Question13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack1.push(scanner.nextInt());
        }
        while(!stack1.empty()) {
            int s1 = stack1.pop();
            if(stack2.empty()){
                stack2.push(s1);
            } else{
                while(!stack2.empty() && stack2.peek() > s1 ) {
                    stack1.push(stack2.pop());
                }
                stack2.push(s1);
            }
        }
        while(!stack2.empty()){
            System.out.print(stack2.pop()+" ");
        }
    }
}