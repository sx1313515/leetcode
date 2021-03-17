package codeinterview;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/15 7:29 下午
 */
public class Question80 {
}
class MedianHolder {
    // PriorityQueue 结构就是堆
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    public MedianHolder() {
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        minHeap = new PriorityQueue<>();  //默认是小堆顶
    }
    public void addNumber(Integer num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        modifyTwoHeaps();
    }
    public Integer getMedian() {
        if (maxHeap.isEmpty()) {
            return null;
        }
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return maxHeap.size() > minHeap.size() ? maxHeap.peek()
                    : minHeap.peek();
        } }
    private void modifyTwoHeaps() {
        if (maxHeap.size() == minHeap.size() + 2) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() == maxHeap.size() + 2) {
            maxHeap.add(minHeap.poll());
        }
    }
}
