package codeinterview;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 描述:最短包含字符串的长度
 * 给定字符串str1和str2，求str1的字串中含有str2所有字符的最小字符串长度。
 * Minimum Window Substring
 * @Author: xiang_song
 * @CreateDate: 2021/3/21 9:33 下午
 */
public class Question134 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        if (length1 < length2) {
            System.out.println(0);
            return;
        }
        HashMap<Character, Integer> needMap = new HashMap<>(); //表示包含子串还需要哪些字符
        for (int i = 0; i < length2; i++) {
            if (needMap.get(chars2[i]) == null) {
                needMap.put(chars2[i], 1);
            } else {
                needMap.put(chars2[i], needMap.get(chars2[i]) + 1);
            }
        }
        int left = 0;
        int min = Integer.MAX_VALUE;
        int target = 0;
        HashMap<Character, Integer> remainMap = new HashMap<>(); //表示母串比子串多出来的
        HashMap<Character, Integer> str2Map = new HashMap<>(needMap); //表示str2的映射关系，方便计算
        for (int right = 0; right < length1; right++) {
            Integer value = needMap.get(chars1[right]);
            if (value == null) {
                if (remainMap.get(chars1[right]) == null) {
                    remainMap.put(chars1[right], 1);
                } else {
                    remainMap.put(chars1[right], remainMap.get(chars1[right]) + 1);
                }
            } else if (value == 1) {
                needMap.remove(chars1[right]);
                if (needMap.size() == 0) {  //包含了子串的所以内容，左指针要开始移动了
                    if (right - left + 1 < min) {
                        min = right - left + 1;
                        target = right;
                    }
                    while (left < right) {
                        if (!str2Map.containsKey(chars1[left])) { //不包含
                            left ++;
                            if (right - left + 1 < min) {
                                min = right - left + 1;
                                target = right;
                            }
                        } else {  //包含
                            if (remainMap.containsKey(chars1[left])) {  //母串还有多的，可以舍弃
                                int remainValue = remainMap.get(chars1[left]);
                                left ++;
                                if (right - left + 1 < min) {
                                    min = right - left + 1;
                                    target = right;
                                }
                                if (remainValue == 1) {
                                    remainMap.remove(chars1[left]);
                                } else {
                                    remainMap.put(chars1[left], remainValue - 1);
                                }
                            } else {  //母串没有多的了，这个时候右指针要往右移动了
                                needMap.put(chars1[left], 1);
                                left ++;
                                break;
                            }
                        }
                    }
                }
            } else {
                needMap.put(chars1[right],value-1);
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
