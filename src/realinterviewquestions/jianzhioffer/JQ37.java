package realinterviewquestions.jianzhioffer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 描述:序列化二叉树
 * 序列化二叉树和反序列号二叉树
 * @Author: xiang_song
 * @CreateDate: 2021/3/27 6:43 上午
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

}
public class JQ37 {

    // Encodes a tree to a single string.
    //BFS
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode pop = list.pop();
            sb.append(pop.val + ",");
            if (pop.left == null) {
                sb.append("null,");
            } else {
                list.add(pop.left);
            }
            if (pop.right == null) {
                sb.append("null,");
            } else {
                list.add(pop.right);
            }
        }
        return sb.toString();
    }
    //DFS
    public String serialize1(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return root.val + "," + serialize1(root.left) + "," + serialize1(root.right);
    }

    // Decodes your encoded data to tree.
    //BFS
    public TreeNode deserialize(String data) {
        if(data == "null"){
            return null;
        }
        String[] dataList = data.split(","); //,是最后元素也不受影像
        TreeNode root = new TreeNode(Integer.parseInt(dataList[0]));  //根节点
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;  //用于从数组里面取树
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!"null".equals(dataList[i])){ //如果为空，那以后的节点都为空。不用加入队列了
                node.left = new TreeNode(Integer.parseInt(dataList[i]));
                queue.add(node.left);  //跟遍历的时候一样
            }
            i++;
            if(!"null".equals(dataList[i])){
                node.right = new TreeNode(Integer.parseInt(dataList[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
    public TreeNode deserialize1(String data) {
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }
    private TreeNode dfs(LinkedList<String> queue) {
        String val = queue.poll();
        if("null".equals(val)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val)); //这个顺序跟遍历的顺序是一样的，怎么遍历就怎么初始化恢复
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
    }
}
