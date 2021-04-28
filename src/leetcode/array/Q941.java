package leetcode.array;

/**
 * 描述:有效的山脉数组
 * 给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * arr.length >= 3
 * 在 0 < i < arr.length - 1 条件下，存在 i 使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * @Author: xiang_song
 * @CreateDate: 2021/4/27 13:46
 */
public class Q941 {
    public boolean validMountainArray(int[] arr) {
        int length = arr.length;
        if (length < 3 || arr[1] < arr[0]) {  //至少升序一次
            return false;
        }
        boolean flag = false;
        for (int i = 1; i < length; i++) {
            if (arr[i] == arr[i - 1]) {
                return false;
            }
            if (!flag && arr[i] < arr[i - 1]) {
                flag = true;
                continue;
            }
            if (flag && arr[i] > arr[i - 1]) {
                return false;
            }
        }
        return flag;
    }
}
