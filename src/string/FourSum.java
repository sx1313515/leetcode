package string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 描述:
 *给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 * @Author: xiang_song
 * @CreateDate: 2019/4/19 17:31
 */
public class FourSum {
    private Set<String> set = new HashSet<>();
    public void combination(int[] nums, int r, String pre,int target) {
        int  i = 0;
        int j = 0;
        for(i = 0; i <= nums.length-r; i++){  //因为组合结果的第一个数肯定不可能是最后一个，是倒数第几个开始
            pre += nums[i]+",";
            int[] nums1 = new int[nums.length - i-1];
            System.arraycopy(nums, i+1, nums1, 0, nums1.length);  //取了一个就从剩下的数里面去n-1个
            if(r==1){
                if()
                set.add(pre);
            }
            else {
                combination(nums1,r-1,pre,target);  //取了一个就从剩下的数里面取n-1个
            }
            pre = pre.substring(0, pre.length()-2);  //把最后一位剔除
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length<4)
            return null;
        combination(nums,4,"",target);
    }
}
