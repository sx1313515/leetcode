package codeinterview;

import java.util.Scanner;

/**
 * 数组的partition调整补充问题
 * 给定一个数组arr，其中只可能含有0、1、2三个值，请实现arr的排序
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 */
public class Question37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        if (n == 1) {
            System.out.print(nums[0]);
            return;
        }
        int left = 0;
        int right = n-1;
        int index = 0;
        while (index <= right) {
            if (nums[index] == 0) {
                nums[index] = nums[left];
                nums[left] = 0;
                left++;
                index++;
            } else if (nums[index] == 1) {
                index++;
            } else {
                nums[index] = nums[right];
                nums[right] = 2;
                right--;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }

    }
}
