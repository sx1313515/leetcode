package datastructure;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 描述:
 *给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 输入: [1,2,0]
 * 输出: 3
 * 输入: [3,4,-1,1]
 * 输出: 2
 * @Author: g
 * @CreateDate: 2019/1/3 14:14
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0;i<length;i++){
            if (nums[i]>max)
                max = nums[i];
            map.put(nums[i], 1);
        }
        for(int i=1;i<=max;i++){
            if(map.get(i)==null)
                return i;
        }
        return max+1;
    }

    public static void main(String[] args) {
        int[] value = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive(value));
    }
}
