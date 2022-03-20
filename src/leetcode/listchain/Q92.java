package leetcode.listchain;

/**
 * 描述:反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * @Author: xiang_song
 * @CreateDate: 2022/3/20 21:34
 */
public class Q92 {
    /**
     * 1、我们定义两个指针，分别称之为 g 和 p
     * 我们首先根据方法的参数 m 确定 g 和 p 的位置。将 g 移动到第一个要反转的节点的前面，将 p 移动到第一个要反转的节点的位置上。我们以 m=2，n=4为例。
     * 2、将 p 后面的元素删除，然后添加到 g 的后面。也即头插法。
     * 3、根据 m 和 n 重复步骤（2）
     * 4、返回 dummyHead.next
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 定义哑巴节点方便操作第一个元素
        ListNode dimmy = new ListNode(0);
        dimmy.next = head;
        ListNode g = dimmy;
        ListNode p = head;
        // 移动p和g到需要翻转的位置
        int i = 1;
        while (i < m) {
            g = g.next;
            p = p.next;
            i++;
        }
        // 将 p 后面的元素删除，然后添加到 g 的后面。也即头插法
        for (int j = 0; j < n - m; j++) {
            ListNode next = p.next;
            ListNode nextNext = next.next;
            p.next = nextNext;
            // 这里要注意，头插法是指向g这个固定节点的下一个，q此刻移动到很后面去了
            next.next = g.next;
            g.next = next;
        }
        return dimmy.next;
    }
}
