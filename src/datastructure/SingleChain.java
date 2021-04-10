package datastructure;

/**
 * ����:
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

    //��ת

    /**
     * ��������ָ�룺 prepre �� curcur ��prepre ��ǰ curcur �ں�
     * ÿ���� prepre �� nextnext ָ�� curcur ��ʵ��һ�ξֲ���ת
     * �ֲ���ת���֮�� prepre �� curcur ͬʱ��ǰ�ƶ�һ��λ��
     * ѭ���������̣�ֱ�� prepre ��������β��
     * @param node
     * @return
     */
    public static Node reverse(Node node) {
        Node cur = null; //��ת��cur�����һ���ڵ㣬Ϊ��
        Node pre = node;
        while (pre != null) {
            Node next = pre.next;  //ȡ��pre����һ���ڵ㣬��Ϊ���ָ��Ȼ�Ҫ�޸�
            pre.next = cur;  //pre��cur��ָ�뷭ת����
            cur = pre;  //cur��preͬʱ��ǰ��
            pre = next;  //cur��preͬʱ��ǰ��
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
