package codeinterview;

/**
 * 描述:根据后序数组重建搜索二叉树
 * 给定一个有 n 个不重复整数的数组 arr，判断 arr 是否可能是节点值类型为整数的搜索二叉树后序遍历的结果。
 * @Author: xiang_song
 * @CreateDate: 2021/3/27 10:27 上午
 */
public class Question173 {
    public boolean isPostArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return isPost(arr, 0, arr.length - 1);
    }
    public boolean isPost(int[] arr, int start, int end) {
        if (start == end) {
            return true;
        }
        int less = -1;
        int more = end;  //最后一个元素是枢纽点
        for (int i = start; i < end; i++) {
            if (arr[end] > arr[i]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        if (less == -1 || more == end) {  //元素都比节点元素大 || 元素都比节点元素小
            return isPost(arr, start, end - 1);
        }
        if (less != more - 1) { //找不到这样的元素，使得可以划分出两部分，左部分比根节点小，右部分比根节点大
            return false;
        }
        return isPost(arr, start, less) && isPost(arr, more, end - 1);  //less左边都是小的  //more右边都是大的
    }
}
