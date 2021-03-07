package codeinterview;

import java.util.HashMap;
import java.util.Scanner;

/**
 *数字字符转化为字母组合的种数
 * 给定一个字符串str，str全部由数字字符组成，如果str中的某一个或者相邻两个字符组成的子串值在1~26之间，则这个子串可以转换为一个字母。
 * 规定‘1’转换为“A”，“2”转换为“B”......"26"转化为“Z“。请求出str有多少种不同的转换结果，由于答案可能会比较大，所以请输出对10^{9}+710
 * 9 *  +7取模后的答案。
 */
public class Question44 {
    private static HashMap<String,Integer> memo = new HashMap<>(16);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(fun(str));
    }

    private static int fun(String str) {
        int length = str.length();
        if (length == 0) {
            return 1;
        }
        if (str.charAt(0) == '0') {
            return 0;
        }
        if (length == 1) {
            return 1;
        }
        Integer integer = memo.get(str);
        if (integer != null) {
            return integer;
        }
        int result = fun(str.substring(1)) + (Integer.valueOf(str.substring(0,2)) > 26 ? 0 : fun(str.substring(2)));
        memo.put(str, result);
        return result;
    }
}
