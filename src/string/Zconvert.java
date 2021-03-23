package string;

/**
 * 描述:
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * @Author: xiang_song
 * @CreateDate: 2019/4/18 17:18
 */
public class Zconvert {
    public static String convert(String s, int numRows) {
        int length = s.length();
        int curRow = 0;
        boolean goingDown = false;
        char[] chars = s.toCharArray();
        if (length <= numRows||numRows==1) {
            return s;
        }else {
            StringBuilder[] sbs = new StringBuilder[numRows];
            for(int i=0;i<numRows;i++){
                sbs[i] = new StringBuilder();
            }
            for (int i = 0; i < length; i++) {  //仔细品尝这里是如何作流程控制的
                sbs[curRow].append(chars[i]);
                if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
                curRow += goingDown ? 1 : -1;
            }
            StringBuilder result = new StringBuilder();
            for(int i=0;i<numRows;i++){
                result.append(sbs[i]);
            }
            return result.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(convert("AB",1));
    }
}
