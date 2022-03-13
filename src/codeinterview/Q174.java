package codeinterview;

import java.util.LinkedList;

/**
 * 描述:判断一棵二叉树是否为搜索二叉树和完全二叉树
 * 给定一棵二叉树，已经其中没有重复值的节点，请判断该二叉树是否为搜索二叉树和完全二叉树。
 * @Author: xiang_song
 * @CreateDate: 2021/3/23 10:10
 */
public class Q174 {
    /**
     * 完全二叉树
     * @param root
     * @return
     */
    public boolean isCBT(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean rightNeedNull = false;
        while (!queue.isEmpty()) {
            TreeNode pop = queue.pop();
            if (rightNeedNull && (pop.left != null || pop.right != null)) { //如果当前节点并不是左右孩子节点全有，那么之后的节点必须都为叶节点，否则返回 false
                return false;
            }
            if (pop.left == null && pop.right != null) {  //只有右节点，没有左节点，肯定不是二叉树
                return false;
            }
            if (pop.left == null || pop.right == null) {  //如果当前节点并不是左右孩子节点全有，那么之后的节点必须都为叶节点，否则返回 false
                rightNeedNull = true;
            }
            if (pop.left != null) {
                queue.push(pop.left);
            }
            if (pop.right != null) {
                queue.push(pop.right);
            }
        }
        return true;
    }


    /**
     * 搜索二叉树
     * 改写一个二叉树中序遍历，在遍历的过程中看节点值是否都是递增的即可
     * @param root
     * @return
     */
    private long maxValue = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {  //maxValue表示上次遍历的元素
        if (root == null) {
            return true;
        }
        // 加if方便快速判断和返回
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= maxValue) {
            return false;
        }
        // 更新最大值
        maxValue = root.val;
        return isValidBST(root.right);

    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
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
