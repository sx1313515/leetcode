package realinterviewquestions.jianzhioffer;

/**
 * 描述:丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * @Author: xiang_song
 * @CreateDate: 2021/4/17 3:52 下午
 */
public class Q49 {
    public static void main(String[] args) {
        new Q49().nthUglyNumber(10);
    }
    public int nthUglyNumber(int n) {
        int[] nums = new int[n]; //用于存丑数
        nums[0] = 1;
        int index1 = 0,index2 = 0,index3 = 0; //定义三个指针,分别指向*2，*3，*5的最后一个数
        for (int i = 1; i < n; i++) {
            nums[i] = Math.min(Math.min(nums[index1] * 2, nums[index2] * 3), nums[index3] * 5);  //可能存在两个数相同的情况，只取一个
            if (nums[i] == nums[index1] * 2) {  //看看是由那个数乘过来的
                index1 ++;
            }
            if (nums[i] == nums[index2] * 3) {
                index2 ++;
            }
            if (nums[i] == nums[index3] * 5) {
                index3++;
            }
        }
        return nums[n - 1];
    }
}
