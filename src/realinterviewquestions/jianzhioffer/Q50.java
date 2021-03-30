package realinterviewquestions.jianzhioffer;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/30 9:28
 */
public class Q50 {
    public static void main(String[] args) {
        System.out.println(new Q50().exchange(new int[]{1,3,5}));
    }
    public double myPow(double x, int n) {
        return 0.0;
    }
    public int[] exchange(int[] nums) {
        int length = nums.length;
        if(length <= 1) {
            return nums;
        }
        int left = 0,right = length -1;
        while(left<right){
            while(left<right && nums[left] % 2 ==1) {
                left++;
            }
            while(left<right && nums[right] % 2 ==0) {
                right--;
            }
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
        return nums;
    }
}
