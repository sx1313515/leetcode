package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * @Author: xiang_song
 * @CreateDate: 2022/3/5 16:40
 */
public class Q94 {
    private List<Integer> resList = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        middle(root);
        return resList;
    }

    /**
     * 中序
     * @param root
     */
    private void middle(TreeNode root) {
        if (root == null) {
            return;
        }
        middle(root.left);
        resList.add(root.val);
        middle(root.right);
    }

    /**
     * 先序
     * @param root
     */
    private void pre(TreeNode root) {
        if (root == null) {
            return;
        }
        resList.add(root.val);
        pre(root.left);
        pre(root.right);
    }

    /**
     * 后序
     * @param root
     */
    private void post(TreeNode root) {
        if (root == null) {
            return;
        }
        post(root.left);
        post(root.right);
        resList.add(root.val);
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
