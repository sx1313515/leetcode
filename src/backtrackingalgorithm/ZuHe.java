package backtrackingalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 * 组合问题：找出从自然数1、2、... 、n（0<n<10）中任取r(0<r<=n)个数的所有组合。从大到小输出。(从小到大输出同理，读者自行琢磨。)
 * @Author: xiang_song
 * @CreateDate: 2019/2/14 13:48
 */
public class ZuHe {
    public static void combination(int[] nums, int r, String pre) {
        int  i = 0;
        int j = 0;
        for(i = 0; i <= nums.length-r; i++){  //因为组合结果的第一个数肯定不可能是最后一个，是倒数第几个开始
            pre += nums[i];
            int[] nums1 = new int[nums.length - i-1];
            System.arraycopy(nums, i+1, nums1, 0, nums1.length);  //取了一个就从剩下的数里面去n-1个
            if(r==1){
                System.out.println(pre);
            }
            else {
                combination(nums1,r-1,pre);  //取了一个就从剩下的数里面取n-1个
            }
            pre = pre.substring(0, pre.length()-1);  //把最后一位剔除
        }
    }

    public static void main(String[] args) {
        combination(new int[]{1,2,3,4,5},5,"");

    }
}
