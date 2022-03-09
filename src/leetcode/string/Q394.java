package leetcode.string;

import java.util.Stack;

/**
 * 描述:字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 示例 1：

 输入：s = "3[a]2[bc]"
 输出："aaabcbc"
 示例 2：

 输入：s = "3[a2[c]]"
 输出："accaccacc"
 示例 3：

 输入：s = "2[abc]3[cd]ef"
 输出："abcabccdcdcdef"
 示例 4：

 输入：s = "abc3[cd]xyz"
 输出："abccdcdcdxyz"

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/decode-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: xiang_song
 * @CreateDate: 2022/3/8 22:07
 */
public class Q394 {

    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        // 存字母的栈
        Stack<String> resStack = new Stack<>();
        // 存数字的栈
        Stack<Integer> multiStack = new Stack<>();
        // 存临时的字母
        StringBuilder res = new StringBuilder();
        // 存临时的乘树
        int multi = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            // 数字
            if (aChar >= '0' && aChar <= '9') {
                // 可能出现几十上百
                multi = multi * 10 + Integer.parseInt(aChar + "");
            // 字母
            } else if (aChar != '[' && aChar != ']') {
                res.append(aChar);
            // 将multi和res入栈，并置空，此时开启新的计算
            } else if (aChar == '[') {
                resStack.push(res.toString());
                multiStack.push(multi);
                res.setLength(0);
                multi = 0;
            // 两个stack出栈，当前res = 栈顶res + 栈顶multi * 当前res
            } else if (aChar == ']') {
                // 栈顶multi
                Integer popMulti = multiStack.pop();
                // 栈顶res
                String popRes = resStack.pop();
                StringBuilder tmp = new StringBuilder();
                for (int j = 0; j < popMulti; j++) {
                    tmp.append(res);
                }
                res = new StringBuilder(popRes + tmp);
            }
        }
        return res.toString();

    }
}
