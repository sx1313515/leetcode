package leetcode101;

/**
 * 描述:两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @Author: xiang_song
 * @CreateDate: 2021/4/15 9:49 下午
 */
public class Q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode move = head;
        boolean flag = false;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (flag) {  //如果之前的运算要进位，则在这一次的基础上+1
                sum++;
            }
            move.next = new ListNode(sum % 10);
            move = move.next;
            flag = sum >= 10 ? true : false;  //是否要进位
        }
        if (flag) {  //如果最后计算完了还要进位，则在最高位设置为1
            move.next = new ListNode(1);
        }
        return head.next;  //头节点是方便计算的，所以返回头节点的下一个节点
    }
}
/**
 * Definition for singly-linked list.*/
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

