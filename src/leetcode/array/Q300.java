package leetcode.array;

import java.util.Arrays;

/**
 * 描述:最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * @Author: xiang_song
 * @CreateDate: 2022/3/13 22:49
 */
public class Q300 {

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] memo = new int[length];
        Arrays.fill(memo,1);
        int max = 1;
        for(int i = 1;i < length;i++) {
            for(int j = 0;j<i;j++) {
                if(nums[i] > nums[j] && memo[j]+1 > memo[i]) {
                    memo[i] = memo[j] + 1;
                    max = Math.max(max,memo[i]);
                }
            }
        }
        return max;
    }
}
