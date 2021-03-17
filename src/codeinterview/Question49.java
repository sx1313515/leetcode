package codeinterview;

import java.util.Scanner;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2020/7/11 7:26
 */
public class Question49 {
    public static void main(String[] args) {
        Node head1 = null;
        Node tail1 = null;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int sub = n - k + 1;
        for(int i = 0; i<n ; i++){
            Node newNode = new Node(sc.nextInt());
            if (head1 == null) {
                head1 = newNode;
                tail1 = newNode;
            } else {
                tail1.next = newNode;
                tail1 = tail1.next;
            }
        }
        if (sub == 1) { //删除头节点
            head1 = head1.next;
        } else {
            int index = 0;
            Node node = head1;
            while (node != null) {
                index ++;
                if (index == sub-1) {
                    node.next = node.next.next;
                    break;
                }
                node = node.next;
            }
        }


        while (head1 != null) {
            System.out.print(head1.key+" ");
            head1 = head1.next;
        }
    }
}


