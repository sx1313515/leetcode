package leetcode.tree;

/**
 * 描述:递增顺序搜索树
 * 给你一棵二叉搜索树的root，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
 * 使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * @Author: xiang_song
 * @CreateDate: 2022/3/9 3:18 下午
 */
public class Q897 {
    private TreeNode head;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode sentinel = new TreeNode();
        head = sentinel;
        dfs(root);
        return sentinel.right;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        TreeNode node = new TreeNode(root.val);
        head.right = node;
        head = node;
        dfs(root.right);
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
