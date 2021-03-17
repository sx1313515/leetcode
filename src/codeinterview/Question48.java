package codeinterview;

import java.util.Scanner;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2020/7/11 7:26
 */
public class Question48 {
    public static void main(String[] args) {
        Node head1 = null;
        Node tail1 = null;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
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
        int m = sc.nextInt();
        Node head2 = null;
        Node tail2 = null;
        for(int i = 0; i<m ; i++){
            Node newNode = new Node(sc.nextInt());
            if (head2 == null) {
                head2 = newNode;
                tail2 = newNode;
            } else {
                tail2.next = newNode;
                tail2 = tail2.next;
            }
        }
        while (head1 != null) {
            int key1 = head1.key;
            while (head2 != null) {
                int key2 = head2.key;
                if (key2 == key1) {
                    System.out.print(key2+" ");
                    head2 = head2.next;
                    break;
                } else if (key2 < key1) {
                    head2 = head2.next;
                } else {
                    break;
                }
            }
            head1 = head1.next;
        }
    }
}

class Node{
    public int key;
    public Node next;
    public Node(int key){
        this.key = key;
        this.next = null;
    }
}
