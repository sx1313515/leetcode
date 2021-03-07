package codeinterview;

import java.util.Scanner;

/**
 * 数组的partition调整
 * 题目描述
 * 给定一个有序数组arr，调整arr使得这个数组的左半部分[1, \frac{n+1}{2}][1,
 * 2
 * n+1
 * ​
 *  ]没有重复元素且升序，而不用保证右部分是否有序
 * 例如，arr = [1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9]，调整之后arr=[1, 2, 3, 4, 5, 6, 7, 8, 9, .....]。
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 */
public class Question36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        if (n <= 2) {
            return;
        }
        int left = 0;
        int cur = nums[0];
        for (int i = 1; i < n; i++) {  //初始化一个数组，不断给这个数组加元素，保证其有序列
            if (nums[i] > cur) {
                left++;
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left]= temp;
                cur = nums[left];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
