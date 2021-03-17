package suanfa;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2020/7/11 7:26
 */
public class SingleChain {
    public static void main(String[] args) {
        Node node = buildChain();
//        Node reverse = reverse(node);
//        while (node != null){
//            System.out.print(node.key+",");
//            node = node.next;
//        }
        reversePrint(node);
        System.out.println();
//        while (reverse != null){
//            System.out.print(reverse.key+",");
//            reverse = reverse.next;
//        }
    }

    private static void reversePrint(Node node) {
        if (node != null) {
            reversePrint(node.next);
            System.out.print(node.key+",");
        }

    }

    public static Node buildChain(){
        Node head = null;
        Node tail = null;
        for(int i = 1; i<10 ; i++){
            Node newNode = new Node(i);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }
        return head;
    }

    //翻转
    public static Node reverse(Node node) {
        if (node == null) {
            return null;
        }
        Node head = node;
        while (node.next != null) {
            Node nextNode = node.next;
            node.next = nextNode.next;
            nextNode.next = head;
            if (nextNode != null) {
                head = nextNode;
            }
        }
        return head;
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
