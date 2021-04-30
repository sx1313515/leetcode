package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 描述:三数之和
 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 注意：答案中不可以包含重复的三元组。
 * @Author: xiang_song
 * @CreateDate: 2021/4/28 15:30
 */
public class Q15 {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);  //先排序，这样可以使用二分法查找剩下的两个元素
        List<List<Integer>> outlist = new ArrayList<>();
        HashSet<String> memo = new HashSet<>();
        int length = num.length;
        int m,n;
        for(int i=0;i<length-2;i++){
            m = i + 1;  //左指针
            n = length-1;  //右指针
            while (m<n){
                if(num[m]+num[n]+num[i]==0){  //满足要求
                    if (memo.add(num[i] + "_" + num[m] + "_" + num[n])) {//不存在，可以产生，并写入集合去重
                        outlist.add(Arrays.asList(num[i], num[m], num[n]));
                    }
                    m++;
                    n--;
                }else if (num[m]+num[n]+num[i]>0){  //太大了，右指针要变小
                    n--;
                }else {  //太小了，左指针要变大
                    m++;
                }
            }
        }
        return outlist;
    }
}
