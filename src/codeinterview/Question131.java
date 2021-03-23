package codeinterview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 描述:找到字符串的最长无重复字符子串
 * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有字母都不相同)。
 * @Author: xiang_song
 * @CreateDate: 2021/3/20 4:34 下午
 */
public class Question131 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        int start = 0;
        int max = 1;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (map.get(arr[i]) == null) {  //之前没出现过的
                map.put(arr[i], 1);
                max = Math.max(max, i - start + 1);
            } else { //之前出现过
                while (start < i) {
                    if (arr[start] == arr[i]) {
                        map.remove(arr[start]);
                        start++;
                        map.put(arr[i], 1);
                        max = Math.max(max, i - start + 1);
                        break;
                    } else {
                        map.remove(arr[start]);
                        start++;
                    }
                }
            }
        }
        System.out.println(max);

    }
}
