package codeinterview;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 描述:并查集
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/12 8:45 下午
 */
public class Question66 {
}
class Element<V> {
    public V value;
    public Element(V value) {
        this.value = value;
    }
}
class UnionFindSet<V> {
    public HashMap<V, Element<V>> elementMap;  //用来存所有的元素
    public HashMap<Element<V>, Element<V>> fatherMap;  //用来存每个节点的上一个节点，模拟树
    public HashMap<Element<V>, Integer> rankMap;  //用来存每个集合的大小，只有根节点才能看出大小
    public UnionFindSet(List<V> list) {
        elementMap = new HashMap<>();
        fatherMap = new HashMap<>();
        rankMap = new HashMap<>();
        for (V value : list) {
            Element<V> element = new Element<V>(value);
            elementMap.put(value, element);
            fatherMap.put(element, element);
            rankMap.put(element, 1);
        } }
    private Element<V> findHead(Element<V> element) {
        Stack<Element<V>> path = new Stack<>();
        while (element != fatherMap.get(element)) {
            path.push(element);
            element = fatherMap.get(element);
        }
        while (!path.isEmpty()) {
            fatherMap.put(path.pop(), element);
        }
        return element;
    }
    //查询a和b这两个数是否属于一个集合
    public boolean isSameSet(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            return findHead(elementMap.get(a)) == findHead(elementMap
                    .get(b));
        }
        return false;
    }
    //把a所在的集合与b所在的集合合并在一起，原本两个集合各自的元素以后都算作同一个集合
    public void union(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            Element<V> aF = findHead(elementMap.get(a));
            Element<V> bF = findHead(elementMap.get(b));
            if (aF != bF) {
                Element<V> big = rankMap.get(aF) >= rankMap.get(bF) ? aF : bF;
                Element<V> small = big == aF ? bF : aF;
                fatherMap.put(small, big);
                rankMap.put(big, rankMap.get(aF) + rankMap.get(bF));
                rankMap.remove(small);
            }
        }
    }
}
