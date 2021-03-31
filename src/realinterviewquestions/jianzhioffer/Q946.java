package realinterviewquestions.jianzhioffer;

import java.util.Stack;

/**
 * 描述: 验证栈序列
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 * @Author: xiang_song
 * @CreateDate: 2021/3/30 17:27
 */
public class Q946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushLength = pushed.length;
        int popLength = popped.length;
        Stack<Integer> stack = new Stack<>();
        if(pushLength != popLength){
            return false;
        }
        int index = 0;
        for (int i = 0; i < pushLength; i++) {
            if (pushed[i] == popped[index]) {  //如果相同就弹出栈依次比较
                index ++;
                while (!stack.isEmpty() && stack.peek() == popped[index]) {
                    stack.pop();
                    index++;
                }
            } else { //如果不相同就入栈
                stack.add(pushed[i]);
            }
        }
        while (!stack.isEmpty()) {  //最后栈只能按顺序弹出，所以里面的元素必须一致
            if (stack.pop() == popped[index]) {
                index++;
            } else {
                return false;
            }
        }
        return true;
    }
}
