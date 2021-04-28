package leetcode101;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述:用队列实现栈
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。
 * @Author: xiang_song
 * @CreateDate: 2021/4/20 14:28
 */
public class Q225 {
    /**
     * Initialize your data structure here.
     */
    public Q225() {

    }

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    /** Push element x onto stack. */
    public void push(int x) {
        queue2.add(x);  //队列2每次添加元素的时候都为空,新加的元素必须是队首元素
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        Queue<Integer> temp = queue2;  //次数queue1为空，交换q1,q2
        queue2 = queue1;
        queue1 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (!queue1.isEmpty()) {
            return queue1.poll();
        }
        return -1;
    }

    /** Get the top element. */
    public int top() {
        if (!queue1.isEmpty()) {
            return queue1.peek();
        }
        return -1;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
