package realinterviewquestions.jianzhioffer;


/**
 * 描述:构建乘积数组
 *
 * @Author: xiang_song
 * @CreateDate: 2021/4/10 3:33 下午
 */
public class Q66 {
    public static void main(String[] args) {
        new Q66().constructArr(new int[]{1, 2, 3, 4, 5});
    }
    public int[] constructArr(int[] a) {
        int length = a.length;
        if (length <= 1) {
            return a;
        }
        int[] left = new int[length];
        int[] right = new int[length];
        int temp = 1;
        for (int i = 0; i < length; i++) {
            temp = temp * a[i];
            left[i] = temp;
        }
        temp = 1;
        for (int i = length - 1; i >= 0; i--) {
            temp = temp * a[i];
            right[length - i - 1] = temp;
        }
        int[] res = new int[length];
        res[0] = right[length - 2];
        res[length - 1] = left[length - 2];
        for (int i = 1; i < length - 1; i++) {
            res[i] = left[i - 1] * right[length - i - 2];
        }
        return res;
    }
}
