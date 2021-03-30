package realinterviewquestions.jianzhioffer;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/30 9:13
 */
public class Q191 {
    public static void main(String[] args) {
        System.out.println(new Q191().hammingWeight(0101));
    }
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 1) {
            if (n % 2 == 1) {
                sum++;
            }
            n = n / 2;
        }
        sum++;
        return sum;
    }
}
