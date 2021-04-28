package leetcode101;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * @Author: xiang_song
 * @CreateDate: 2021/4/20 15:11
 */
public class Q66 {
    //类比两数之和
    public int[] plusOne(int[] digits) {
        List<Integer> list = new LinkedList<>();
        boolean flag = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            int cur = digits[i];
            if (i == digits.length-1) {
                cur++;
            }
            if (flag) {
                cur++;
            }
            list.add(0,cur % 10);
            flag = cur >= 10 ? true : false;
        }
        if (flag) {
            list.add(0, 1);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
