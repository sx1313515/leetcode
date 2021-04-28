package leetcode.array;

/**
 * 描述:移动零
   给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @Author: xiang_song
 * @CreateDate: 2021/4/25 15:53
 */
public class Q283 {
    //把不是0的元素移到左边，其他填充0
    public void moveZeroes(int[] nums) {
        int index = 0;
        if (nums.length <= 1) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index ++;
            }
        }
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
