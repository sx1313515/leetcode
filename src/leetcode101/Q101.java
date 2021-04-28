package leetcode101;


/**
 * 描述: 判断二叉树是否对称
 * @Author: xiang_song
 * @CreateDate: 2021/3/18 19:07
 */
public class Q101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {  //空树是对称的
            return true;
        }
        return dfs(root.left, root.right);
    }

    /**
     * 这里必须传左树和右树
     * @param left
     * @param right
     * @return
     */
    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {  //左右树为空也是对称的
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            return dfs(left.left, right.right) && dfs(left.right, right.left); //左树的左边=右树的右边，左树的右边等于右树的左边
        }
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
