package leetcode101;

/**
 * 描述:返回树是否是平衡二叉树
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/18 19:07
 */
public class Q110 {
    public boolean isBalances(TreeNode root) {
        return dept(root) != -1;
    }

    private int dept(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dept(root.left);
        int right = dept(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;  //这里巧用-1来快速返回
        }
        return 1 + Math.max(left,right);  //一颗树的深度等于左右树较长的深度+1
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
