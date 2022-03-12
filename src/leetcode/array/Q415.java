package leetcode.array;

/**
 * 描述: 字符串相加
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
 * @Author: xiang_song
 * @CreateDate: 2022/3/10 6:43 下午
 */
public class Q415 {

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        // 进位
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            // 余数
            sb.append((a + b + carry) % 10);
            // 整数进位
            carry = (a + b + carry) / 10;
            i --;
            j --;
        }
        // 最后算完可能还有进位
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();

    }


}
