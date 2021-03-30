package leetcode101;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 描述:二叉树的最近公共祖先
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/27 2:50 下午
 */
public class Q236 {
    private HashMap<Integer, TreeNode> map = new HashMap<>();  //存储每个节点的父节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        HashSet<Integer> set = new HashSet<>();
        while (p != null) {  //找出p的父节点并放入set中
            set.add(p.val);
            p = map.get(p.val);
        }
        while (q != null) {  //找出q的
            if (set.contains(q.val)) {
                return q;
            } else {
                q = map.get(q.val);
            }
        }
        return null;
    }

    private void dfs(TreeNode root) {  //把每个节点和其父节点放入map中
        if (root.left != null) {
            map.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            dfs(root.right);
        }
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

