package leetcode.listchain;

import java.util.ArrayList;

/**
 * 描述: 排序链表
 *给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * @Author: xiang_song
 * @CreateDate: 2022/3/20 22:38
 */
public class Q148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<Integer> list = new ArrayList<>();
        ListNode move = head;
        while (move != null) {
            list.add(move.val);
            move = move.next;
        }
        list.sort(Integer::compareTo);
        ListNode dimmy = new ListNode(0);
        ListNode tail = dimmy;
        for (Integer item :
                list) {
            ListNode node = new ListNode(item);
            tail.next = node;
            tail = node;
        }
        return dimmy.next;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.sort(Integer::compareTo);
        list.stream().forEach(System.out::println);
    }

}
