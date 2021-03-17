package codeinterview;

import java.util.HashMap;

/**
 * 描述:设计有setAll功能的哈希表
 * 哈希表常见的三个操作时put、get和containsKey，而且这三个操作的时间复杂度为O(1)。现在想加一个setAll功能，就是把所有记录value都设成统一的值。请设计并实现这种有setAll功能的哈希表，并且put、get、containsKey和setAll四个操作的时间复杂度都为O(1)。
 * [友情提示]: C++选手若有需要可以使用unordered_map替换map来将复杂度从O(log n)降为O(1)
 * @Author: xiang_song
 * @CreateDate: 2021/3/10 10:22 下午
 */
public class Question62 {
}
class MyValue<V> {
    private V value;
    private long time;
    public MyValue(V value, long time) {
        this.value = value;
        this.time = time;
    }
    public V getValue() {
        return this.value;
    }
    public long getTime() {
        return this.time;
    } }
class MyHashMap<K, V> {
    private HashMap<K, MyValue<V>> baseMap;
    private long time;
    private MyValue<V> setAll;
    public MyHashMap() {
        this.baseMap = new HashMap<K, MyValue<V>>();
        this.time = 0;
        this.setAll = new MyValue<V>(null, -1);
    }
    public boolean containsKey(K key) {
        return this.baseMap.containsKey(key);
    }
    public void put(K key, V value) {
        this.baseMap.put(key, new MyValue<V>(value, this.time++));
    }
    public void setAll(V value) {
        this.setAll = new MyValue<V>(value, this.time++);
    }
    public V get(K key) {
        if (this.containsKey(key)) {
            if (this.baseMap.get(key).getTime() > this.setAll.getTime()) {
                return this.baseMap.get(key).getValue();
            } else {
                return this.setAll.getValue();
            }
        } else {
            return null;
        }
    }
}