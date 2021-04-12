package leetcode101;

/**
 * 描述:返回树是否是平衡二叉树：要么是一棵空树，要么任何一个节点的左右子树高度差的绝对值不超过 1。给定一棵二叉树，判断这棵二叉树是否为平衡二叉树。
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/18 19:07
 */
public class Q110 {
    public boolean isBalances(TreeNode root) {
        return dept(root) != -1;
    }

    private int dept(TreeNode root) {  //设个方法既可以计算树的深度，又可以判断是否是平衡二叉树
        if (root == null) {  //空树深度为0
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
