package leetcode.array;

/**
 * 描述:搜索插入位置
 *  给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * @Author: xiang_song
 * @CreateDate: 2022/3/13 08:58
 */
public class Q35 {
    public int searchInsert(int[] nums, int target) {
        if (nums[0] > target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        int high = nums.length - 1;
        int low = 0;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // 注意最后的指针是落在mid那里
        // 不用--，因为替换了当前的位置
        return nums[mid] > target ? mid : ++mid;
    }

    public static void main(String[] args) {
        new Q35().searchInsert(new int[]{1, 3}, 2);
    }

}
