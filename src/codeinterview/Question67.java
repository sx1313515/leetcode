package codeinterview;

import java.util.*;

/**
 * 描述:路径数组变为统计数组
 * 给定一个路径统计数组paths，表示一张图。paths[i]==j代表城市i连向城市j，如果paths[i]==i，则表示i城市是首都，一张图里只会有一个首都且图中除首都指向自己之外不会有环。例如，paths=[9,1,4,9,0,4,8,9,0,1]，代表的图如图9-14所示。
 * 由数组表示的图可以知道，城市1是首都，所以距离为0，离首都距离为1的城市只有城市9，离首都距离为2的城市有城市0、3和7，离首都距离为3的城市有城市4和8，离首都距离为4的城市有城市2、5和6。所以距离为0的城市有1座，距离为1的城市有1座，距离为2的城市有3座，距离为3的城市有2座，距离为4的城市有3座。那么统计数组为nums=[1,1,3,2,3,0,0,0,0,0]
 * [要求]
 * 时间复杂度为O(n)O(n)，额外空间复杂度为O(1)O(1)
 * @Author: xiang_song
 * @CreateDate: 2021/3/12 9:48 下午
 */
public class Question67 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] result = new int[n];
        result[0] = 1;
        int[] memo = new int[n];
        Arrays.fill(memo,-1);
        int caption = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] == i) {
                caption = i;
                memo[caption] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == caption) {
                continue;
            }
            int count = 0;
            int index = i;
            if (memo[a[index]] == n + 1) {
                memo[index] = n + 1;
                break;
            } else if (memo[a[index]] != -1) {
                memo[index] = 1+memo[a[index]];
                result[1+memo[a[index]]] = result[1+memo[a[index]]]+1;
                break;
            }
            HashSet<Integer> hashSet = new HashSet<>();
            while (a[index] != index && !hashSet.contains(index)) {
                hashSet.add(index);
                index = a[index];
                count++;
            }
            if (a[index] == index) {
                memo[i] = count;
                result[count] = result[count]+1;
            } else {
                Iterator<Integer> iterator = hashSet.iterator();
                while (iterator.hasNext()) {
                    memo[iterator.next()] = n + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(result[i]+" ");;
        }
    }
}
