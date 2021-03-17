package codeinterview;

import java.util.*;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/15 9:57 下午
 */
public class Question84 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        HashMap<String, Node> hashMap = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            String next = sc.next();
            Node node = hashMap.get(next);
            if (node == null) {
                hashMap.put(next, new Node(next));
            } else {
                node.incre();
            }
        }
        PriorityQueue<Node> minHeap = new PriorityQueue<>(k, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.time == o2.time) {
                    return o1.value.compareTo(o2.value);
                } else {
                    return o1.time - o2.time;
                }
            }
        });
        Collection<Node> values = hashMap.values();
        for (Node value : values) {
            if (minHeap.size() < k) {
                minHeap.add(value);
            } else {
                Node peek = minHeap.peek();
                if (peek.time < value.time || (peek.time == value.time && value.value.compareTo(peek.value) == -1)) {
                    minHeap.poll();
                    minHeap.add(value);
                }
            }
        }
        while (!minHeap.isEmpty()) {
            Node poll = minHeap.poll();
            System.out.println(poll.value+" "+poll.time);
        }



    }
    static class Node{
        int time = 1;
        String value;

        public Node(String value) {
            this.value = value;
        }
        private void incre() {
            this.time++;
        }
    }
}
