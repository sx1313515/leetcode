package leetcode.math;

/**4的幂
 * 描述:4的幂
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * @Author: xiang_song
 * @CreateDate: 2021/4/25 16:07
 */
public class Q342 {
    public boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        while (n >= 4) {
            if (n % 4 != 0) {
                return false;
            } else {
                n = n / 4;
            }
        }
        return n == 1;

    }
}
