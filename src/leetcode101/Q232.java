package leetcode101;

import java.util.Stack;

/**
 * 描述: 用栈实现队列
 *请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * @Author: xiang_song
 * @CreateDate: 2022/2/28 4:35 下午
 */
public class Q232 {
    // 用来存放数据
    Stack<Integer> stack1 = new Stack();
    // 用来中转
    Stack<Integer> stack2 = new Stack<>();

    public Q232() {

    }

    public void push(int x) {
        while (! stack1.empty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (! stack2.empty()) {
            stack1.push(stack2.pop());
        }
        stack2 = new Stack<>();
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.empty();
    }
}
