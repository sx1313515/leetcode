package backtrackingalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaiLie {

    private static int num = 0;

    public static void letterCombinations() {
        List list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        fun(list,"");
    }

    private static void fun(List list,String str) {
        int pre = 0;
        for(int i=0;i<list.size();i++){
            if(list.size()==1){
                str += list.get(i);
                num++;
                System.out.println(str);
            }else {
                str += list.get(i);
                pre = (int) list.get(i);
                list.remove(i);
                fun(list,str);
                list.add(i, pre);
                str = str.substring(0, str.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        letterCombinations();
        System.out.println(num);
    }




}
