package codeinterview;

import java.util.Scanner;

/**
 * 描述:在数组中找到出现次数大于一半的数
 * 给定一个整型数组arr，请打印其中出现次数大于一半的数，如果没有这样的数，请输出-1。
 * @Author: xiang_song
 * @CreateDate: 2021/3/26 15:44
 */
public class Question154 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        if (n == 1) {
            System.out.println(nums[0]);
            return;
        }
        if (n == 2) {
            System.out.println(nums[0] == nums[1] ? nums[0] : -1);
            return;
        }
        int time = 1;
        int cur = nums[0];
        for (int i = 1; i < n; i++) {  //删除n-1个元素
            if (time == 0) {
                cur = nums[i];
                time++;
                continue;
            }
            if (nums[i] != cur) {
                time--;
            } else {
                time++;
            }
        }
        time = 0;
        for (int i = 0; i < n; i++) {  // //删除n-1个元素，剩下的那个元素大于一半就是了
            if (nums[i] == cur) {
                time++;
            }
        }
        System.out.println(time > n/2 ? cur : -1);
    }
}
