package leetcode101;

/**
 * 描述:二叉树的直径
 *给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * @Author: xiang_song
 * @CreateDate: 2021/3/18 19:07
 */
public class Q543 {
    private int sum = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return sum-1;  //sum是节点数，直径是算边数，减一
    }

    /**
     * 求树的深度
     * @param root
     * @return
     */
    private int dept(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(dept(root.left),dept(root.right));
        //一颗树的深度等于左右树较长的深度+1
    }
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        //当前节点的最大直径=左数深度+右树深度+1（根节点）
        int i = 1 + dept(root.left) + dept(root.right);
        sum = Math.max(sum, i);  //取最大值
        dfs(root.left);
        dfs(root.right);
    }

    public static class TreeNode {
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
