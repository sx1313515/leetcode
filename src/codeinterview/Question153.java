package codeinterview;

import java.util.Scanner;

/**
 * 描述:需要排序的最短子数组长度
 * 给定一个无序数组arr，求出需要排序的最短子数组的长度，
 * 对子数组排序后能使得整个数组有序，即为需要排序的数组。
 * 例如：arr=[1,5,3,4,2,6,7]返回4，因为只有[5,3,4,2]需要排序。
 * @Author: xiang_song
 * @CreateDate: 2021/3/26 6:01 上午
 */
public class Question153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int min = Integer.MAX_VALUE;
        int leftindex = -1;
        for (int i = n-1; i >= 0; i--) {  //找出左边第一个比右边要大的元素
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                leftindex = i;
            }
        }
        if (leftindex == -1) {
            System.out.println(0);
            return;
        }
        int max = Integer.MIN_VALUE;
        int rightindex = -1;
        for (int i = 0; i < n; i++) {  //找出右边最后一个比左边边要大的元素
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                rightindex = i;
            }
        }
        System.out.println(rightindex-leftindex+1);  //两者中间的就是要排序的
    }
}
