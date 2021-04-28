package leetcode.string;

import java.sql.SQLOutput;

/**
 * 描述:
 *给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * @Author: xiang_song
 * @CreateDate: 2021/4/27 9:16
 */
public class Q168 {
    public static void main(String[] args) {
        System.out.println(new Q168().convertToTitle(701));
    }

    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 26) {
            return String.valueOf((char) (columnNumber + 64));
        }
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber --;
            sb.append((char) (columnNumber%26 + 65));
            columnNumber = columnNumber / 26;
        }
        return sb.reverse().toString();
    }
}
