package leetcode.listnode;


/**
 * 描述:给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * @Author: xiang_song
 * @CreateDate: 2022/3/3 6:12 下午
 */
public class Q206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
