package leetcode101;

import java.util.HashMap;

/**
 * 描述:给定一个整数数组，求这个数组中的数字可以组成的最长连续序列有多长。
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/15 11:06
 */
public class Q128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
                if(map.containsKey(nums[i]-1)){
                    //左边存在元素，左边这个元素一定是在当前连续序列里面最右边的元素，取出左边的连续序列最左边的元素
                    int left = nums[i]-1-map.get(nums[i]-1)+1;
                    int length = nums[i]-left+1;
                    map.put(left, length);  //更新当前连续序列最左边元素的长度
                    map.put(nums[i], length); //更新当前连续序列最边边元素的长度
                    max = Math.max(max, length);
                }
                if(map.containsKey(nums[i]+1)){
                    //右边存在元素，右边这个元素一定是在当前连续序列里面最右边的元素，取出右边的连续序列最右边的元素
                    int right = nums[i]+1+map.get(nums[i]+1)-1;
                    int length = right-nums[i] + 1;
                    map.put(right, length);  //更新当前连续序列最右边元素的长度
                    map.put(nums[i], length); //更新当前连续序列最左边元素的长度
                    max = Math.max(max, length);
                    max = Math.max(max, length);
                }
            }
        }
        return max==0?1:max;
    }
}
