package leetcode101;

/**
 * 描述:给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 删除链表的倒数第 N 个结点
 * @Author: xiang_song
 * @CreateDate: 2021/4/15 10:13 下午
 */
public class Q19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size ++;
            temp = temp.next;
        }
        if (n > size) {
            return null;
        }
        if (n == size) {
            head = head.next;
            return head;
        }
        int count = 0;
        ListNode cur = head;
        ListNode pre = cur;
        while (cur != null) {
            count ++;
            if (count == size - n + 1) {
                pre.next = cur.next;
                return head;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
