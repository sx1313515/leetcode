package leetcode.array;

/**
 * 描述:比特位计数
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * @Author: xiang_song
 * @CreateDate: 2022/3/9 11:20 上午
 */
public class Q338 {
    /**
     * 使用规律加动态规划去做
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            // 如果是奇数，则比前面的偶数多一个1，多了最低位的1
            if (i % 2 == 1) {
                res[i] = res[i - 1] + 1;
            // 如果是偶数，则跟除以2的偶数一样的1，因为只是最低位多了个0而已
            } else {
                res[i] = res[i / 2];
            }
        }
        return res;
    }
}
