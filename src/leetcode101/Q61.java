package leetcode101;

/**
 * 描述:旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * @Author: xiang_song
 * @CreateDate: 2021/4/28 8:45 下午
 */
public class Q61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {  //计算链接大小
            iter = iter.next;
            n++;
        }
        int add = n - k % n;  //需要移动多少次
        if (k % n == 0) {  //刚好回到原处，不变
            return head;
        }
        iter.next = head;  //将链表连成环
        while (add-- > 0) {  //移动
            iter = iter.next;
        }
        ListNode ret = iter.next;  //环段开，返回头节点
        iter.next = null;
        return ret;
    }
}
