package backtrackingalgorithm;

import java.util.ArrayList;
import java.util.List;

public class PaiLie1 {
    public static List<String> fun(int[] n){
        List<String> store = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        int length = n.length;
        for(int i=0;i<length;i++){
            values.add(n[i]);
        }
        StringBuilder sb = new StringBuilder();
        fun1(store,values,sb,length);
        return store;
    }

    private static void fun1(List<String> store,List<Integer> values,StringBuilder sb,int length) {
        for(int i=0;i<values.size();i++){
            sb.append(values.get(i));
            int temp = values.get(i);
            values.remove(i);
            if(sb.length()==length){
                store.add(sb.toString());
                System.out.println(sb.toString());
            }else{
                fun1(store,values,sb,length);
            }
            values.add(i,temp);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    public static void main(String[] args) {
        List<String> fun = fun(new int[]{1, 2, 3});
        System.out.println();
    }
}
