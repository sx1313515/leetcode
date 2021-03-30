package codeinterview;
import java.util.*;

public class Test{
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.add(2);
        queue.add(3);
        queue.add(1);
        System.out.println(queue);
    }
    static class stu{
        public int age;
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue queue = new PriorityQueue();
        for(int a : arr) {
            if(queue.size() == k) {
                queue.poll();
            }
            queue.add(a);
        }
        return null;
//        return queue.toArray(new int[2]);
    }
    public Integer[] getLeastNumbers1(int[] arr, int k) {
        ArrayList<Integer> queue = new ArrayList();
        return queue.toArray(new Integer[2]);
    }
}