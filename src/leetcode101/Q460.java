package leetcode101;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * 描述:LFU 缓存
 * 一、获取元素
 *  1、如果不存在直接返回
 *  2、如果存在
 *      1）更新那个节点的使用频率，从频率map中移除在加入
 *      2）更新全局最小频次
 * 二、插入元素
 *  1、如果原来存在
 *     1）替换value
 *     2）更新那个节点的使用频率，从频率map中移除在加入
 *     3）更新全局最小频次
 *  2、如果原来不存在
 *     1）容量超标了
 *       （1）根据全局最小频次获取频次队列，并删除第一个
 *       （2）map移除最小频次的那个元素
 *       （3）新元素加入到map中
 *       （4）全局最小min为1，新元素加入min为1的队列中
 *     2）容量未超标
 *       （1）新元素加入到map中
 *       （2）全局最小min为1，新元素加入min为1的队列中
 * @Author: xiang_song
 * @CreateDate: 2021/3/12 9:01
 */
public class Q460 {
}

class LFUCache {
    Map<Integer, Node> cache;  // 存储缓存的内容
    Map<Integer, LinkedHashSet<Node>> freqMap; // 存储每个频次对应的双向链表,可能有多个数的频次一样
    int size;
    int capacity;
    int min; // 存储当前最小频次

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            freqInc(node);
        } else {
            if (size == capacity) {
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }

    void freqInc(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        if (freq == min && set.size() == 0) {  //原来的频次最小，并且这个频次只有这一个数
            min = freq + 1;
        }
        // 加入新freq对应的链表
        node.freq++;
        LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freqMap.put(freq + 1, newSet);
        }
        newSet.add(node);
    }

    void addNode(Node node) {
        LinkedHashSet<Node> set = freqMap.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(1, set);
        }
        set.add(node);
        min = 1;
    }

    Node removeNode() {
        LinkedHashSet<Node> set = freqMap.get(min);
        Node deadNode = set.iterator().next(); //两个或更多个键具有相同使用频率时，应该去除 最久未使用 的键，因为LinkedHashSet是有序的，所以第一个元素一定是最早插入的
        set.remove(deadNode);
        return deadNode;
    }
}

class Node {
    int key;
    int value;
    int freq = 1;  //出现频次

    public Node() {}

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
