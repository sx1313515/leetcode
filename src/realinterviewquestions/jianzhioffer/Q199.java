package realinterviewquestions.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * @Author: xiang_song
 * @CreateDate: 2021/4/1 8:28 下午
 */
public class Q199 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;
        new Q199().rightSideView(root);
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            arrayList.add(queue.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.pop();
                if (pop != null) {
                    if (pop.right != null) {
                        queue.add(pop.right);
                    }
                    if (pop.left != null) {
                        queue.add(pop.left);
                    }
                }

            }
        }
        return arrayList;
    }
   static class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
