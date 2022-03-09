package leetcode.tree;

import java.util.LinkedList;

/**
 * 描述: 给定二叉树的根节点 root ，返回所有左叶子之和。
 *
 * @Author: xiang_song
 * @CreateDate: 2022/3/6 13:50
 */
public class Q404 {
    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return sum;
    }
    // 深度优先
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // 左树不为空
        if (root.left != null) {
            if (isLeaf(root.left)) {
                sum = sum + root.left.val;
            } else {
                dfs(root.left);
            }
        }
        // 右树不为空
        if (root.right != null) {
            if (isLeaf(root.right)) {
                return;
            } else {
                dfs(root.right);
            }
        }
    }

    // 广度优先
    private int bfs(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            int count = linkedList.size();
            for (int i = 0; i < count; i++) {
                TreeNode pop = linkedList.pop();
                if (pop.left != null) {
                    if (isLeaf(pop.left)) {
                        sum += pop.left.val;
                    } else {
                        linkedList.add(pop.left);
                    }
                }
                if (pop.right != null) {
                    if (!isLeaf(pop.right)) {
                        linkedList.add(pop.right);
                    }
                }
            }
        }
        return sum;
    }

    public boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }


    class TreeNode {
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
