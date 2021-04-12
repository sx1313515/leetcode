package codeinterview;

/**
 * 描述:判断t1树是否包含t2树全部的拓扑结构
 * 树的子结构
 * 空树不是任意一个树的子结构
 * @Author: xiang_song
 * @CreateDate: 2021/3/27 10:27 上午
 */
public class Question170 {


//    特例处理： 当 树 A 为空 或 树 B 为空 时，直接返回 false ；
//    返回值： 若树 B 是树 A 的子结构，则必满足以下三种情况之一，因此用或 || 连接；
//    以 节点 A 为根节点的子树 包含树 B ，对应 recur(A, B)；
//    树 B 是 树 A 左子树 的子结构，对应 isSubStructure(A.left, B)；
//    树 B 是 树 A 右子树 的子结构，对应 isSubStructure(A.right, B)；
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    //以节点A为根节点的子树是否包含树B
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true; //当节点 B 为空：说明树 B 已匹配完成（越过叶子节点），因此返回 true
        if(A == null || A.val != B.val) return false; //当节点 A为空：说明已经越过树 A 叶子节点，即匹配失败，返回 false当节点A为空：说明已经越过树A叶子节点，
        // 即匹配失败，返回 false
        return recur(A.left, B.left) && recur(A.right, B.right);
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
