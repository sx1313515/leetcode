package leetcode101;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:给定先序遍历和中序遍历结果，还原这棵树
 * @Author: xiang_song
 * @CreateDate: 2021/3/18 19:07
 */
public class Q105 {
    public static void main(String[] args) {
        new Q105().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    //这里的start和end两个指针是只包含start这边的元素，不包括end那边的元素的
    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        // preorder 为空，直接返回 null
        if (p_start == p_end) {
            return null;
        }
        int root_val = preorder[p_start];  //先序遍历的第一个节点一定是根节点
        TreeNode root = new TreeNode(root_val);
        //在中序遍历中找到根节点的位置
        int i_root_index = 0;
        for (int i = i_start; i < i_end; i++) {
            if (root_val == inorder[i]) {
                i_root_index = i;
                break;
            }
        }
        int leftNum = i_root_index - i_start;  //左子树的长度
        //递归的构造左子树
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);  //传入先序的上半段和中序的上半段
        //递归的构造右子树
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);  //传入先序的下半段和中序的下半段
        return root;
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
