package codeinterview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 描述:拼接所有的字符串产生字典序最小的字符串
 * 假设有两个字符串，分别记为 a 和 b，a 和 b 拼起来的字符串表示为 a.b。那么如果 a.b 的
 * 字典顺序小于 b.a，就把字符串 a 放在前面，否则把字符串 b 放在前面。每两个字符串之间都按
 * 照这个标准进行比较，以此标准排序后，再依次串起来的大写字符串就是结果。这样做为什么
 * 对呢？当然需要证明。
 * @Author: xiang_song
 * @CreateDate: 2021/3/21 8:23 下午
 */
public class Question130 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(strs[i]);
        }
        System.out.println(sb.toString());
    }
}
