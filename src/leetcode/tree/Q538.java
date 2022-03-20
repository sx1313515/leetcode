package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:把二叉搜索树转换为累加树
 *  给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: xiang_song
 * @CreateDate: 2022/3/20 22:02
 */
public class Q538 {
    int sum = 0;
    // 最优解法
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
    // 把所有数先放数组
    List<Integer> list = new ArrayList<>();
    // 解法一
    public TreeNode convertBST1(TreeNode root) {
        dfs(root);
        dfsSum(root);
        return root;
    }

    // 一个个节点去求和
    private void dfsSum(TreeNode root) {
        if (root == null) {
            return;
        }
        root.val = count(root.val);
        dfsSum(root.left);
        dfsSum(root.right);
    }

    private int count(int val) {
        int sum = 0;
        for (Integer e : list) {
            if (e >= val) {
                sum += e;
            }
        }
        return sum;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }


}
