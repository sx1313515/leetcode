package codeinterview;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *给定一个正数数组arr，arr的累加和代表金条的总长度，arr的每个数代表金条要分成的长度。规定长度为k的金条分成两块，费用为k个铜板。返回把金条分出arr中的每个数字需要的最小代价。
 * [要求]
 * 时间复杂度为O(n \log n)O(nlogn)，空间复杂度为O(n)O(n)
 */
public class Question51 {
    private static HashMap<String,Integer> memo = new HashMap<>(16);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(n);
        for (int i = 0; i < n; i++) {
            priorityQueue.add(sc.nextLong());
        }
        if (n == 1) {
            System.out.println(0);
            return;
        }
        long sum = 0l;
        while (priorityQueue.size() > 1) {
            Long first = priorityQueue.poll();
            Long second = priorityQueue.poll();
            sum = sum+first+second;
            priorityQueue.add(first+second);
        }
        System.out.println(sum);


    }
}
