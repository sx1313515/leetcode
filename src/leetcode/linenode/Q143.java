package leetcode.linenode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @Author: xiang_song
 * @CreateDate: 2022/3/10 22:26
 */
public class Q143 {
    /**
     * 我们利用线性表存储该链表，然后利用线性表可以下标访问的特点，直接按顺序访问指定元素，重建该链表即可。
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        //存到 list 中去，可以实现线性访问
        // list的第一个元素就是head
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        //头尾指针依次取元素
        int i = 0, j = list.size() - 1;
        // 重建链表
        while (i < j) {
            // 最左边指向最右边的
            list.get(i).next = list.get(j);
            // 左边右移
            i++;
            //偶数个节点的情况，会提前相遇，相遇就表示全部链接好了，得退出
            if (i == j) {
                break;
            }
            // 最右边指向最左边
            list.get(j).next = list.get(i);
            // 右边左移
            j--;
        }
        list.get(i).next = null;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
