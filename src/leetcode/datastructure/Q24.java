package leetcode.datastructure;

import java.util.List;

/**
 * 描述:
 *给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @Author: xiang_song
 * @CreateDate: 2021/4/28 16:58
 */
public class Q24 {
    /**
     * 也可以通过迭代的方式实现两两交换链表中的节点。
     * 创建哑结点 dummyHead，令 dummyHead.next = head。令 temp 表示当前到达的节点，初始时 temp = dummyHead。每次需要交换 temp 后面的两个节点。
     * 如果 temp 的后面没有节点或者只有一个节点，则没有更多的节点需要交换，因此结束交换。否则，获得 temp 后面的两个节点 node1 和 node2，通过更新节点的指针关系实现两两交换节点。
     * 具体而言，交换之前的节点关系是 temp -> node1 -> node2，交换之后的节点关系要变成 temp -> node2 -> node1，因此需要进行如下操作。
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode assistNode = new ListNode();
        assistNode.next = head;
        ListNode temp = assistNode;
        while (temp.next != null && temp.next.next != null) {
            ListNode next = temp.next;
            ListNode nextNext = next.next;
            next.next = nextNext.next;
            nextNext.next = next;
            temp.next = nextNext;
            temp = next;
        }
        return assistNode.next;
    }
}

  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

