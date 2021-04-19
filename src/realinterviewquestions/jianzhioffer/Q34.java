package realinterviewquestions.jianzhioffer;

/**
 * 描述:在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。要求O(logn)
 * @Author: xiang_song
 * @CreateDate: 2021/4/11 9:33 上午
 */
public class Q34 {
    public static void main(String[] args) {
        System.out.println(new Q34().search(new int[]{5, 7, 7, 8, 8, 10}, 8));;
    }
    public int search(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        int index = -1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (target == nums[mid]) {
                index = mid;
                break;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (index == -1) {
            return 0;
        }
        int count = 1;
        int ll = index -1;
        int rr = index +1;
        while (ll >= 0) {
            if (nums[ll] == target) {
                count ++;
                ll--;
            }else {
                break;
            }
        }
        while (rr < nums.length) {
            if (nums[rr] == target) {
                count ++;
                rr++;
            }else {
                break;
            }
        }
        return count;
    }
}
