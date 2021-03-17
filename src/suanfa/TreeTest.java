package suanfa;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2020/7/4 8:31 上午
 */
public class TreeTest {
    public static TreeNode buildTree(TreeNode treeNode,int key) {
        if (treeNode == null) {
            return new TreeNode(key);
        } else {
            if (key < treeNode.key) {
                treeNode.leftNode = buildTree(treeNode.leftNode, key);
            } else {
                treeNode.rightNode = buildTree(treeNode.rightNode, key);
            }
            return treeNode;
        }
    }

    public static void xianxu(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        } else {
            System.out.println(treeNode.key);
            xianxu(treeNode.leftNode);
            xianxu(treeNode.rightNode);
        }
    }
    public static void zhongxu(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        } else {
            zhongxu(treeNode.leftNode);
            System.out.println(treeNode.key);
            zhongxu(treeNode.rightNode);
        }
    }
    public static void houxu(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        } else {
            houxu(treeNode.leftNode);
            houxu(treeNode.rightNode);
            System.out.println(treeNode.key);
        }
    }
    public static void main(String[] args) {
        int[] values = new int[]{3,5, 4, 1, 2, 8, 6, 7};
        TreeNode treeNode = null;
        for (int i = 0; i < values.length; i++) {
            treeNode = buildTree(treeNode,values[i]);
        }
        System.out.println("先序");
        xianxu(treeNode);
        System.out.println("中序");
        zhongxu(treeNode);
        System.out.println("后序");
        houxu(treeNode);
        String str = 's' + "ds";
        System.out.println(str);
    }
}
class TreeNode{
    public int key;
    public TreeNode leftNode;
    public TreeNode rightNode;
    public TreeNode(int key) {
        leftNode = null;
        rightNode = null;
        this.key = key;
    }

}

