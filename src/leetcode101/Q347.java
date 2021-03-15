package leetcode101;

import java.util.*;

/**
 * 描述:347. Top K Frequent Elements (Medium)
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/10 15:06
 */
public class Q347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,3};
        topKFrequent(nums, 2);
    }
    public static void topKFrequent(int[] nums, int k) {

        // key为数字,value为key出现的次数
        HashMap<Integer, Integer> keyCountMap = new HashMap<>();
        // 定义一个优先级队列，将key保存进去
        // 自定义优先级比较器，从map中取对应value(即出现次数)越大，优先级越高
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (keyCountMap.get(o1) < keyCountMap.get(o2)) {
                    return 1; // o1次数小,排后面}
                } else if (keyCountMap.get(o1) > keyCountMap.get(o2)) {
                    return -1; // o1次数大 优先级高 排前面}
                }
                else{
                    return 0;
                }
            }
        });

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            if(keyCountMap.get(nums[i]) == null) {
                keyCountMap.put(nums[i],1);
            } else {
                int count = keyCountMap.get(nums[i]);
                count ++;
                keyCountMap.put(nums[i],count);
            }
        }

        // 遍历map 加入优先级队列
        for (Map.Entry<Integer, Integer> entry :
                keyCountMap.entrySet()) {
            priorityQueue.add(entry.getKey());
        }

        // 拿出前k个放入list
        for (int i = 0; i <k ; i++) {
            System.out.println(priorityQueue.poll());
        }
    }






}
