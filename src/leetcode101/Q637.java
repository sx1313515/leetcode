package leetcode101;


import java.util.*;

/**
 * 描述:给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * @Author: xiang_song
 * @CreateDate: 2021/3/18 19:07
 */
public class Q637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        int temp = 0;
        int side = 1;
        while (!queue.isEmpty()) {
            side = count;
            Double sum = 0.0;
            while (count > 0) {
                count --;
                TreeNode pop = queue.pop();
                sum += pop.val;
                if (pop.left != null) {
                    queue.add(pop.left);
                    temp++;
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                    temp++;
                }
            }
            count = temp;
            temp = 0;
            list.add(sum / side);

        }
        return list;
    }


    public class TreeNode {
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
