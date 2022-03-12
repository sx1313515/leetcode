package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 描述:找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * @Author: xiang_song
 * @CreateDate: 2022/3/9 2:48 下午
 */
public class Q448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1);
        }
        List<Integer> resList = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (map.get(i) == null) {
                resList.add(i);
            }
        }
        return resList;
    }
}
