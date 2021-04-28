package leetcode101;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2021/4/20 16:33
 */
public class Q155 {
    public Q155() {

    }

    private PriorityQueue<Integer> queue = new PriorityQueue<>();
    private Stack<Integer> stack = new Stack<>();
    public void push(int val) {
        stack.add(val);
        queue.add(val);
    }

    public void pop() {
        Integer pop = stack.pop();
        queue.remove(pop);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return queue.peek();
    }
}
