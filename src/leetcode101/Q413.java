package leetcode101;

/**
 * 描述:给定一个数组，求这个数组中连续且等差的子数组一共有多少个。
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/23 13:50
 */
public class Q413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] memo = new int[nums.length];
        int sum = 0;
        for(int i = 2;i<nums.length;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                memo[i] = memo[i-1]+1;
                sum += memo[i];
            }else{
                memo[i] = 0;
            }
        }
        return sum;
    }
}
