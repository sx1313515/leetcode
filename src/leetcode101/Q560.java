package leetcode101;

import java.util.HashMap;

/**
 * 描述:
 *给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * @Author: xiang_song
 * @CreateDate: 2021/3/16 19:32
 */
public class Q560 {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> sumTimeMap = new HashMap<>(length);
        sumTimeMap.put(0, 1);
        int sum = 0;
        int result = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            Integer time = sumTimeMap.get(sum - k);
            if (time != null) {
                result += time;
            }
            if (sumTimeMap.get(sum) == null) {
                sumTimeMap.put(sum, 1);
            } else {
                sumTimeMap.put(sum, sumTimeMap.get(sum) + 1);
            }
        }
        return result;

    }
}
