package leetcode101;

import java.util.Stack;

/**
 * 描述:
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * @Author: xiang_song
 * @CreateDate: 2022/3/5 08:06
 */
public class Q234 {
    /**
     * 翻转后一个个比较
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode tail = head;
        while (tail != null) {
            stack.push(tail.val);
            tail = tail.next;
        }
        tail = head;
        while (tail != null && !stack.empty()) {
            if (tail.val != stack.pop()) {
                return false;
            }
            tail = tail.next;
        }
        return true;
    }
}
