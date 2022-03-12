package leetcode.linenode;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2022/3/10 21:26
 */
public class Q445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        // 进位
        int carry = 0;
        // 创建一个臊子节点
        ListNode head = new ListNode();
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            ListNode node = new ListNode((a + b + carry) % 10);
            // 这里得用头插法，不能用尾插法，因为链表计算完还要翻转回来
            node.next = head.next;
            head.next = node;
            carry = (a + b + carry) / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            // 这里得用头插法，不能用尾插法，因为链表计算完还要翻转回来
            ListNode node = new ListNode(1);
            node.next = head.next;
            head.next = node;
        }
        return head.next;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
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
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode a1 = new ListNode(5);
        ListNode a2 = new ListNode(6);
        ListNode a3 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;

        new Q445().addTwoNumbers(l1, a1);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
