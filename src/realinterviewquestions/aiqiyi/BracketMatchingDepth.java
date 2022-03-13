package realinterviewquestions.aiqiyi;

import java.util.Scanner;

/**
 * 描述:括号匹配深度
 * 空串""是一个合法的括号匹配序列
 * 如果"X"和"Y"都是合法的括号匹配序列,"XY"也是一个合法的括号匹配序列
 * 如果"X"是一个合法的括号匹配序列,那么"(X)"也是一个合法的括号匹配序列
 * 每个合法的括号序列都可以由以上规则生成。
 * 例如: "","()","()()","((()))"都是合法的括号序列 对于一个合法的括号序列我们又有以下定义它的深度:
 *
 * 空串""的深度是0
 * 如果字符串"X"的深度是x,字符串"Y"的深度是y,那么字符串"XY"的深度为max(x,y)
 * 如果"X"的深度是x,那么字符串"(X)"的深度是x+1
 * 例如: "()()()"的深度是1,"((()))"的深度是3。牛牛现在给你一个合法的括号序列,需要你计算出其深度。
 * @Author: xiang_song
 * @CreateDate: 2022/3/13 10:55
 */
public class BracketMatchingDepth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int cnt = 0, max = 0, i;
        // 就是看左边最长的连续左括号有多少个，最大的就是括号的最大深度了
        for (i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(')
                cnt++;
            else
                cnt--;
            max = Math.max(max, cnt);
        }
        sc.close();
        System.out.println(max);
    }
}
