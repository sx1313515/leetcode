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
        List<List<String>> repository = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int length = digit.length;
        if(length==0)
            return list;
        char[][] alphabet = new char[][]{{'a','b','c'},{'d','e','f'}
                ,{'g','h','i'},{'j','k','l'},{'m','n','o'}
                ,{'p','q','r','s'},{'t','u','x'},{'w','x','y','z'}};
        for(int i=0;i<length;i++){
            List<String> strlist = new ArrayList<>();
            for(int j=0;j<alphabet[Integer.valueOf(String.valueOf(digit[i]))-2].length;j++){
                strlist.add(String.valueOf(alphabet[Integer.valueOf(String.valueOf(digit[i]))-2][j]));
            }
            repository.add(strlist);
        }
        StringBuffer sb = new StringBuffer("");
        fun(repository,0,sb,list);
        return list;
    }

    private static void fun(List<List<String>> repository,int row,StringBuffer sb,List<String> list) {
        int digi_length = repository.size();
        int row_length = repository.get(row).size();
        for(int i=0;i<row_length;i++){
            sb.append(repository.get(row).get(i));
            if(row==digi_length-1){
                list.add(sb.toString());
            }else {
                fun(repository,row+1,sb,list);
            }
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        String str = new String("23");
        List<String> strings = letterCombinations(str);
        System.out.println();
    }

}
