package realinterviewquestions.jianzhioffer;

/**
 * 描述:输入两个链表，找出它们的第一个公共节点。
 * 两个头结点同时往下走，谁先到最后，谁就指向另外一条的头结点，最后肯定会出现一定，使得两个指针到尾结点的距离相同，遍历完即可
 * @Author: xiang_song
 * @CreateDate: 2021/4/1 9:09
 */
public class Q160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != null || nodeB != null) {
            if (nodeA != null && nodeB != null) {
                if (nodeA == nodeB) {  //同一个对象，用==
                    return nodeA;
                } else {
                    nodeA = nodeA.next;
                    nodeB = nodeB.next;
                }
            } else if (nodeA == null) {
                nodeA = headB;
            } else {
                nodeB = headA;
            }
        }
        return null;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
