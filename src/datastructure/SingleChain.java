package datastructure;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2020/7/11 7:26
 */
public class SingleChain {
    public static void main(String[] args) {
        Node node = buildChain();
        Node reverse = reverse(node);
        while (reverse != null) {
            System.out.print(reverse.key+" ");
            reverse = reverse.next;
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

    /**
     * 定义两个指针： prepre 和 curcur ；prepre 在前 curcur 在后。
     * 每次让 prepre 的 nextnext 指向 curcur ，实现一次局部反转
     * 局部反转完成之后， prepre 和 curcur 同时往前移动一个位置
     * 循环上述过程，直至 prepre 到达链表尾部
     * @param node
     * @return
     */
    public static Node reverse(Node node) {
        Node cur = null; //翻转后cur是最后一个节点，为空
        Node pre = node;
        while (pre != null) {
            Node next = pre.next;  //取出pre的下一个节点，因为这个指针等会要修改
            pre.next = cur;  //pre和cur的指针翻转过来
            cur = pre;  //cur和pre同时往前移
            pre = next;  //cur和pre同时往前移
        }
        return cur;
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
