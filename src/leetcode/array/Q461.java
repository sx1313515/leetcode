package leetcode.array;

import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2022/3/9 11:38 上午
 */
public class Q461 {
    /**
     * // 先异或，再统计1的个数
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int sum;
        List<Integer> bina = bina(x ^ y);
        sum = (int) bina.stream().filter(e -> e == 1).count();
        return sum;
    }

    /**
     * 将十进制数转二进制
     * @param n
     * @return
     */
    public List<Integer> bina(int n) {
        List<Integer> list = new LinkedList<>();
        if (n == 0) {
            list.add(0);
            return list;
        }
        while (n != 0) {
            list.add(0, n % 2);
            n = n / 2;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Q461().hammingDistance(1, 3));;
    }
}
