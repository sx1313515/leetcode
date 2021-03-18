package leetcode101;

/**
 * 描述:给定两个增序的链表，试将其合并成一个增序的链表
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/18 13:58
 */
public class Q21 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n4.next = n5;
        n5.next = n6;
        new Q21().mergeTwoLists(n1, n4);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode();
        ListNode tailNode = headNode;
        if (l1 == null && l2 == null) {
            return null;
        }
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ListNode curNode = new ListNode(l1.val);
                tailNode.next = curNode;
                tailNode = curNode;
                l1 = l1.next;
            } else {
                ListNode curNode = new ListNode(l2.val);
                tailNode.next = curNode;
                tailNode = curNode;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            ListNode curNode = new ListNode(l1.val);
            tailNode.next = curNode;
            tailNode = curNode;
            l1 = l1.next;
        }
        while (l2 != null) {
            ListNode curNode = new ListNode(l2.val);
            tailNode.next = curNode;
            tailNode = curNode;
            l2 = l2.next;
        }
        return headNode.next;
    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
