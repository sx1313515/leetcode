package leetcode.array;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class Q189 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        new Q189().rotate(nums,3);
    }
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (k % length == 0) {
            return;
        }
        int index = k % length;
        int[] nums0 = Arrays.copyOf(nums, length);
        for (int i = 0; i < length; i++) {
            nums[i] = nums0[(i-index+length)%length];
        }
        nums = nums0;
    }
}
