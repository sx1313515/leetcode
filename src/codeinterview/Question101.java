package codeinterview;

import java.util.Scanner;
import java.util.Stack;

/**
 * 描述:单调栈结构
 * 给定一个不含有重复值的数组 arr，找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i] 小的位置。返回所有位置相应的信息。
 * @Author: xiang_song
 * @CreateDate: 2021/3/18 8:54
 */
public class Question101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int[][] memo = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (stack1.isEmpty() || a[stack1.peek()] < a[i]) {
                stack1.add(i);
            } else {
                while (!stack1.isEmpty()) {
                    if (a[stack1.peek()] > a[i]) {
                        Integer pop = stack1.pop();
                        memo[pop][0] = i;
                    }else {
                        break;
                    }
                }
                stack1.add(i);
            }
        }
        for (int i = n-1; i >= 0; i--) {
            if (stack2.isEmpty() || a[stack2.peek()] < a[i]) {
                stack2.add(i);
            } else {
                while (!stack2.isEmpty()) {
                    if (a[stack2.peek()] > a[i]) {
                        Integer pop = stack2.pop();
                        memo[pop][1] = i;
                    }else {
                        break;
                    }
                }
                stack2.add(i);
            }
        }
        while (!stack1.isEmpty()) {
            memo[stack1.pop()][0] = -1;
        }
        while (!stack2.isEmpty()) {
            memo[stack2.pop()][1] = -1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j >= 0; j--) {
                System.out.print(memo[i][j]+" ");
            }
            System.out.println();
        }
    }
}
