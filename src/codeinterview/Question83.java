package codeinterview;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/15 8:46 下午
 */
public class Question83 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }
        int[] result = new Question83().topKSum(nums1, nums2, k);
        for (int i = 0; i < k; i++) {
            System.out.print(result[i] + "");
        }
    }
    public class Node {
        public int index1;// arr1 中的位置
        public int index2;// arr2 中的位置
        public int value;// arr1[index1] + arr2[index2]的值
        public Node(int i1, int i2, int sum) {
            index1 = i1;
            index2 = i2;
            value = sum;
        }
    }
    // 生成大根堆的比较器
    public class MaxHeapComp implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.value - o1.value;
        } }
    public int[] topKSum(int[] arr1, int[] arr2, int topK) {
        if (arr1 == null || arr2 == null || topK < 1) {
            return null;
        }
        topK = Math.min(topK, arr1.length * arr2.length);
        int[] res = new int[topK];
        int resIndex = 0;
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(new MaxHeapComp());
        HashSet<String> positionSet = new HashSet<String>();
        int i1 = arr1.length - 1;
        int i2 = arr2.length - 1;
        maxHeap.add(new Node(i1, i2, arr1[i1] + arr2[i2]));
        positionSet.add(i1 + "_" + i2);
        while (resIndex != topK) {
            Node curNode = maxHeap.poll();
            res[resIndex++] = curNode.value;
            i1 = curNode.index1;
            i2 = curNode.index2;
            if (!positionSet.contains(i1 - 1 + "_" + i2)) {
                positionSet.add(i1 - 1 + "_" + i2);
                maxHeap.add(new Node(i1 - 1, i2, arr1[i1 - 1] + arr2[i2]));
            }
            if (!positionSet.contains(i1 + "_" + (i2 - 1))) {
                positionSet.add(i1 + "_" + (i2 - 1));
                maxHeap.add(new Node(i1, i2 - 1, arr1[i1] + arr2[i2 - 1]));
            }
        }
        return res;
    }
}
