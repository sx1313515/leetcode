package leetcode.array;

/**
 * 描述: 山脉数组的峰顶索引
 *
 * @Author: xiang_song
 * @CreateDate: 2022/3/13 09:43
 */
public class Q852 {
    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return i - 1;
            }
        }
        return 0;
    }
}
