package leetcode.listchain;

/**
 * 获取环型链表的入环口
 */
public class Q142 {
    /**
     * 从链表起点head开始到入口点的距离a,与从slow和fast的相遇点（如图）到入口点的距离相等。
     * 因此我们就可以分别用一个指针（ptr1, prt2），同时从head与slow和fast的相遇点出发，每一次操作走一步，
     * 直到ptr1 == ptr2，此时的位置也就是入口点！
     * 到此第二个问题也已经解决。
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode cross = null;
        while (slow != null && slow.next != null && fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cross = slow;
                break;
            }
        }
        if (cross == null) {
            return null;
        }
        while (head != null && cross !=null) {
            if(head == cross) {
                return cross;
            }
            head = head.next;
            cross = cross.next;
        }
        return null;
    }
}
