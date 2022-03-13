package leetcode.tree;

/**
 * 描述:二叉树剪枝
 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
 *
 * 返回移除了所有不包含 1 的子树的原二叉树。
 *
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 * @Author: xiang_song
 * @CreateDate: 2022/3/12 16:04
 */
public class Q814 {
    public TreeNode pruneTree(TreeNode root) {
        boolean cut = isCut(root);
        // 根节点都被剪没了
        if (cut) {
            return null;
        }
        return root;
    }

    /**
     * 判断这棵树要不要剪枝
     * @param node
     * @return
     */
    private boolean isCut(TreeNode node) {
        // 空树肯定剪枝
        if (node == null) {
            return true;
        }
        // 左树要不要剪
        boolean isLeftCut =  isCut(node.left);
        // 右树要不要剪
        boolean isRightCut =  isCut(node.right);
        if (isLeftCut) {
            node.left = null;
        }
        if (isRightCut) {
            node.right = null;
        }
        // 如果这个节点是0并且左右子节点都被剪枝，那么就需要剪枝
        return node.val == 0 && isLeftCut && isRightCut;
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
