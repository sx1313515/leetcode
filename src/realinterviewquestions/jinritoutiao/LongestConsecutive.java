package realinterviewquestions.jinritoutiao;

import java.util.HashMap;

/**
 * 描述:
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 思路：时间复杂度为O(n)，肯定要使用Hash表的。
 * @Author: g
 * @CreateDate: 2019/1/9 14:48
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
                if(map.containsKey(nums[i]-1)){
                    int length = merge(map,nums[i]-1,nums[i]);
                    max = Math.max(max, length);
                }
                if(map.containsKey(nums[i]+1)){
                    int length = merge(map,nums[i],nums[i]+1);
                    max = Math.max(max, length);
                }
            }
        }
        return max==0?1:max;
    }

    private int merge(HashMap<Integer, Integer> map, int i,int j) {
        int left = i-map.get(i)+1;
        int right = j+map.get(j)-1;
        int length = right-left+1;
        map.put(left, length);
        map.put(right, length);
        return length;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new LongestConsecutive().longestConsecutive(nums));
    }
}
