package leetcode101;

/**
 * 描述:二叉树的直径
 *给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * @Author: xiang_song
 * @CreateDate: 2021/3/18 19:07
 */
public class Q543 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(1);
        root.left = left;
        root.right = right;
        new Q543().diameterOfBinaryTree(root);
    }
    private int sum = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return sum-1;
    }

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
        int i = 1 + dept(root.left) + dept(root.right);
        sum = Math.max(sum, i);
        dfs(root.left);
        dfs(root.right);
    }
    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        sum = Math.max(sum, L+R+1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
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
