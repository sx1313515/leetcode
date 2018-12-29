package backtrackingalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @Author: g
 * @CreateDate: 2018/12/29 10:47
 */
public class letterCombinations {
    public static List<String> letterCombinations(String digits) {
        char[] digit = digits.trim().toCharArray();
        int length = digit.length;
        if(length==0)
            return Arrays.asList(new String(""));
        char[][] alphabet = new char[][]{{'a','b','c'},{'d','e','f'}
                ,{'g','h','i'},{'j','k','l'},{'m','n','o'}
                ,{'p','q','r','s'},{'t','u','x'},{'w','x','y','z'}};
        List<List<String>> repository = new ArrayList<>();
        for(int i=0;i<length;i++){
            List<String> strlist = new ArrayList<>();
            for(int j=0;j<alphabet[Integer.valueOf(String.valueOf(digit[i]))-2].length;j++){
                strlist.add(String.valueOf(alphabet[Integer.valueOf(String.valueOf(digit[i]))-2][j]));
            }
            repository.add(strlist);
        }
        StringBuffer sb = new StringBuffer("");
        List<String> list = new ArrayList<>();
//        for(int i=0;i<alphabet[Integer.valueOf(String.valueOf(digit[0]))].length-2;i++){
//            sb = new StringBuffer(String.valueOf(alphabet[Integer.valueOf(String.valueOf(digit[0]))-2][i]));
//            fun(digit,alphabet,0,i,sb,list);
//        }
        fun(repository,0,0,sb,list);
        return list;
    }

    private static void fun(List<List<String>> repository,int row, int colunm,StringBuffer sb,List<String> list) {
        int digi_length = repository.size();
        int row_length = repository.get(row).size();
        if(colunm==row_length){
            return;
        }
        for(int i=0;i<row_length;i++){
            sb.append(repository.get(i).get(colunm));
            if(row==digi_length-1){
                list.add(sb.toString());
                sb.deleteCharAt(digi_length-1);
                fun(repository,row,colunm+1,sb,list);
            }else {
                fun(repository,row+1,0,sb,list);
            }
        }
    }

    public static void main(String[] args) {
        String str = new String("23");
        letterCombinations(str);
    }

}
