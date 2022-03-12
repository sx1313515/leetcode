package leetcode.linenode;

/**
 * 剑指 Offer II 029. 排序的循环链表
 *  给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
 *
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 *
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 *
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
 * @Author: xiang_song
 * @CreateDate: 2022/3/12 11:16
 */
public class Q708 {
    public ListNode insert(ListNode head, int insertVal) {
        if (head == null) {
            head = new ListNode(insertVal);
            head.next = head;
            return head;
        }
        ListNode cur = head;
        // 链表一定是循环的，这里只需判断是否回到开始的地方
        while (cur.next != head) {
            ListNode next = cur.next;
            // 注意这是是使链表从某个点看起来递增
            if (next.val < cur.val && next.val >= insertVal) {
                break;
            } else if (next.val < cur.val && cur.val <= insertVal) {
                break;
            } else if (cur.val <= insertVal && next.val >= insertVal) {
                break;
            } else {
                cur = next;
            }
        }
        // 还有一种情况，循环走完了都还没出现三种可以插入的情况，则说明环是递增的而且插入的数最大
        ListNode node = new ListNode(insertVal);
        node.next = cur.next;
        cur.next = node;
        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
