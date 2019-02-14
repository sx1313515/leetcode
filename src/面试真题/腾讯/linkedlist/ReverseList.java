package 面试真题.腾讯.linkedlist;

/**
 * 描述:
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @Author: xiang_song
 * @CreateDate: 2019/2/13 13:49
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode prev = new ListNode(1);
        ListNode last = new ListNode(2);
        ListNode song = prev;
        prev = last;
        ListNode temp = new ListNode(3);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
