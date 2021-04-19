package realinterviewquestions.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 描述:输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * @Author: xiang_song
 * @CreateDate: 2021/4/11 7:44 上午
 */
public class Q57 {
    public static void main(String[] args) {
        new Q57().findContinuousSequence(9);
    }
    public int[][] findContinuousSequence(int target) {
        if (target <= 2) {
            return null;
        }
        int left = 1;
        int right = 2;
        ArrayList<Integer> per = new ArrayList<>();
        ArrayList<ArrayList<Integer>> total = new ArrayList<>();
        int sum = left+right;
        per.add(left);
        per.add(right);
        while (left <= (target + 1) / 2) {
            while (right <= (target + 1) / 2) {
                if (sum == target) {
                    total.add(new ArrayList<>(per));
                    right++;
                    sum += right;
                    per.add(right);
                } else if (sum < target){
                    right++;
                    sum += right;
                    per.add(right);
                } else {
                    break;
                }
            }
            sum -= left;
            left++;
            per.remove(0);
        }
        int[][] result = new int[total.size()][];
        for (int i = 0; i < total.size(); i++) {
            result[i] = new int[total.get(i).size()];
            for (int j = 0; j < total.get(i).size(); j++) {
                result[i][j] = total.get(i).get(j);
            }
        }
        return result;
    }
}
