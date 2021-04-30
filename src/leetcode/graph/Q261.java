package leetcode.graph;

import java.util.*;

/**
 * 描述:
 * 给定从 0 到 n-1 标号的 n 个结点，和一个无向边列表（每条边以结点对来表示），请编写一个函数用来判断这些边是否能够形成一个合法有效的树结构。
 * 示例 1：
 * 输入: n = 5, 边列表 edges = [[0,1], [0,2], [0,3], [1,4]]
 * 输出: true
 *
 *
 * 思路：要判断一个图是否为树，首先要知道树的定义。
 * 一棵树必须具备如下特性：
 * （1）是一个全连通图（所有节点相通）
 * （2）无回路
 * 其中（2）等价于：（3）图的边数=节点数-1
 * 因此我们可以利用特性（1）（2）或者（1）（3）来判断。
 * @Author: xiang_song
 * @CreateDate: 2021/4/29 9:11
 */
public class Q261 {
    /**
     *
     * @param n 节点数
     * @param edges  row代表有多少条边，column代表两个节点间有连线
     * @return
     */
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();  //<节点序号，该节点连接的所有节点的集合>
        for(int i=0; i<edges.length; i++) {
            for(int j=0; j<2; j++) {
                Set<Integer> pairs = graph.get(edges[i][j]);
                if (pairs == null) {
                    pairs = new HashSet<>();
                    graph.put(edges[i][j], pairs);
                }
                pairs.add(edges[i][1-j]);
            }
        }
        Set<Integer> visited = new HashSet<>();  //记录访问过的节点
        LinkedList<Integer> current = new LinkedList<>();  //使用一个队列来做bfs
        visited.add(0);  //0访问了
        current.add(0);  //从0开始访问，0相当于根节点
        //下面是一个bfs的过程
        while (!current.isEmpty()) {
            int size = current.size();
            for (int i = 0; i < size; i++) {
                Integer node = current.poll();
                Set<Integer> pairs = graph.get(node);  //获取到当前节点相连的所有节点
                if (pairs == null) {  //没有相连的节点就换下一个
                    continue;
                }
                for(Integer pair: pairs) {  //遍历相连的节点
                    if (visited.contains(pair)) {  //如果之前存在过说明出现了环，直接返回false
                        return false;
                    }
                    current.add(pair);
                    visited.add(pair);  //访问过
                    graph.get(pair).remove(node);  //加入A和B两个节点相连，通过A找到了B就不需要B找到A了，因为A和B都已经放入set了
                }
            }
        }
        return visited.size() == n;  //看访问到的节点数是否等于给定的节点数
    }
}
