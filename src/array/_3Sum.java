package array;

import java.util.*;

/**
* @Description:    java类作用描述
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
* @Author:         xiang_song
* @CreateDate:     2018/12/25 15:31
*/
public class _3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outlist = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        for(int i=0;i<length-2;i++){
            for (int j = i+1; j <length-1 ; j++) {
                for (int k = j+1; k <length; k++) {
                    if((nums[i]+nums[j]+nums[k])==0){
                        int flag=0;
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        for(int h=0;h<outlist.size();h++){
                            List<Integer> integers = outlist.get(h);
                            Collections.sort(integers);
                            Collections.sort(list);
                            if(integers.get(0)==list.get(0)&&integers.get(1)==list.get(1)&&integers.get(2)==list.get(2)){
                                flag=1;
                                break;
                            }
                        }
                        if(flag==0){
                            outlist.add(list);
                        }
                        list = new ArrayList<>();
                        continue;
                    }
                }
            }
        }
        return outlist;
    }
    public List<List<Integer>> threeSum2(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> outlist = new ArrayList<>();
        int flag=0;
        int length = num.length;
        int m,n;
        for(int i=0;i<length-2;i++){
            m = i + 1;
            n = length-1;
            while (m<n){
                if(num[m]+num[n]+num[i]==0){
                    for(int h=0;h<outlist.size();h++){
                        List<Integer> integers = outlist.get(h);
                        if(integers.get(0)==num[i]&&integers.get(1)==num[m]&&integers.get(2)==num[n]){
                            flag=1;
                            break;
                        }
                        flag=0;
                    }
                    if (flag==0){
                        outlist.add(Arrays.asList(num[i], num[m], num[n]));
                    }
                    m++;n--;
                }else if (num[m]+num[n]+num[i]>0){
                    n--;
                }else {
                    m++;
                }
            }
        }
        return outlist;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        _3Sum s = new _3Sum();
        List<List<Integer>> lists = s.threeSum2(nums);
    }
}
