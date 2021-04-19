package realinterviewquestions.jianzhioffer;

/**
 * 描述:圆圈中最后剩下的数字
 *
 * @Author: xiang_song
 * @CreateDate: 2021/4/10 8:27 下午
 */
public class Q62 {
    public static void main(String[] args) {
        System.out.println(new Q62().lastRemaining(5,3));
    }
    public int lastRemaining(int n, int m) {
        boolean[] memo = new boolean[n];
        int count = 0;
        int total = n;
        int index = -1;
        while (total > 1) {
            index = (index + 1)%n;
            if (!memo[index]) {
                count++;
                if (count == m) {
                    count = 0;
                    total --;
                    memo[index] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!memo[i]) {
                return i;
            }
        }
        return 0;
    }
}
