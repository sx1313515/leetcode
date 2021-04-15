package realinterviewquestions.jianzhioffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述:
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * @CreateDate: 2021/4/10 10:09 下午
 */
public class Q59 {
    Queue<Integer> queue;
    Deque<Integer> deque;
    public Q59() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }
    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    /**
     * 将元素 value 入队 queue ；
     * 将双向队列中队尾 所有 小于 value 的元素弹出（以保持 deque 非单调递减），并将元素 value 入队 deque ；
     * @param value
     */
    public void push_back(int value) {
        queue.offer(value);
        while(!deque.isEmpty() && deque.peekLast() < value)
            deque.pollLast();
        deque.offerLast(value);
    }

    /**
     * 若队列 queue 为空，则直接返回 -1−1 ；
     * 否则，将 queue 首元素出队；
     * 若 deque 首元素和 queue 首元素 相等 ，则将 deque 首元素出队（以保持两队列 元素一致 ） ；
     * @return
     */
    public int pop_front() {
        if(queue.isEmpty()) return -1;
        if(queue.peek().equals(deque.peekFirst()))
            deque.pollFirst();
        return queue.poll();
    }
}
