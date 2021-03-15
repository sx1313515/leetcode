package leetcode101;

import java.util.HashMap;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/12 9:38
 */
public class Q146 {
}
class LRUCache {
    private HashMap<Integer,Integer> map;
    private int capacity;
    private int size = 0;
    public LRUCache(int capacity) {
        map = new HashMap<>(16);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }
        int value = map.get(key);

        return value;
    }

    public void put(int key, int value) {

    }
}
