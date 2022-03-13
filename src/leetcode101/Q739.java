package leetcode101;

import java.util.Stack;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/11 19:05
 */
public class Q739 {
    /**
     * 使用单调栈
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];
        // 存到目前还没有出现高温度的第几天
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                    Integer pop = stack.pop();
                    result[pop] = i - pop;
                }
                stack.push(i);
            }
        }
        return result;
    }
}
