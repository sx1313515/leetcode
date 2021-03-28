package leetcode101;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * @Author: xiang_song
 * @CreateDate: 2021/3/27 9:23 上午
 */
public class Q103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        if (root == null) {
            return listList;
        }
        boolean lefttoRight = true;  //当前从左到右还是右到左
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {  //跟普通的层次遍历一样的，就只是塞数据的时候正序和逆序切换就可以了
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {  //如果统计每层的元素可以使用for循环
                TreeNode pop = queue.pop();
                if (lefttoRight) {
                    list.add(pop.val);
                } else {
                    list.add(0, pop.val);
                }
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                }
            }
            listList.add(list);
            lefttoRight = !lefttoRight;
        }
        return listList;
    }
}
