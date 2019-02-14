package 面试真题.腾讯.arrayandstring;

import java.util.HashMap;

/**
 * 描述:
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * @Author: xiang_song
 * @CreateDate: 2019/2/12 16:42
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();  //利用哈希表
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.get(nums[i])!=null)
                return true;
            else
                hashMap.put(nums[i], 1);
        }
        return false;
    }
}
