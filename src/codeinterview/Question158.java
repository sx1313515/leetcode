package codeinterview;

/**
 * 描述:向有序的环形单链表中插入新节点
 * 一个环形单链表从头节点 head 开始不降序，同时由最后的节点指回头节点。
 * 给定这样一个环形单链表的头节点 head 和 一个整数 num，
 * 请生成节点值为 num 的新节点，并插入到这个环形链表中，保证调整后的链表依然有序。
 * @Author: xiang_song
 * @CreateDate: 2021/3/26 10:25 下午
 */
public class Question158 {
    public class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        } }
    public Node insertNum(Node head, int num) {
        Node node = new Node(num);
        if (head == null) {
            node.next = node;
            return node;
        }
        Node pre = head;
        Node cur = head.next;
        //查找插入的元素应该放哪里
        while (cur != head) { //head不是最后一个节点
            if (pre.value <= num && cur.value >= num) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return head.value < num ? head : node; //如果总共只有一个节点，返回小的那个为头
    }
}
