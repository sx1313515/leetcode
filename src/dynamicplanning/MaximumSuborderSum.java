package dynamicplanning;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 */
public class MaximumSuborderSum {
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int max=nums[0],count=nums[0];
        for(int i=1;i<nums.length;i++){
            if(count<=0){
                count = nums[i];
            }else{
                count = count+nums[i];
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
