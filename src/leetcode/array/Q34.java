package leetcode.array;

/**
 * 描述:在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * @Author: xiang_song
 * @CreateDate: 2022/3/7 21:07
 */
public class Q34 {

    public int[] searchRange(int[] nums, int target) {
        int[] res =  new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int hight = nums.length - 1;
        int low = 0;
        int mid = 0;
        // 二分法
        // 注意这里是小于等于
        while (low <= hight) {
            mid = (low + hight) / 2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] > target) {
                hight = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        low = mid;
        hight = mid;
        while (low >= 0 && nums[low] == target) {
            res[0] = low;
            low--;
        }
        while (hight < nums.length && nums[hight] == target) {
            res[1] = hight;
            hight++;
        }
        return res;
    }

    public static void main(String[] args) {
        new Q34().searchRange(new int[]{1, 4}, 4);
    }
}
