package backtrackingalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * @Author: g
 * @CreateDate: 2019/1/2 14:31
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        List<String> origin = new ArrayList<>();
        origin.add("(");
        origin.add(")");
        fun(list,sb,origin,0,0,n);
        return list;
    }

    private void fun(List<String> list, StringBuilder sb,List<String> origin,int lcount,int rcount,int n) {

        for(int i=0;i<origin.size();i++){
            boolean flag=true;
            sb.append(origin.get(i));
            if(origin.get(i).equals("(")) {
                lcount++;
                flag=true;
            } else {
                rcount++;
                flag=false;
            }
            if(lcount+rcount==2*n){
                if(lcount==n&&rcount==n){
                    list.add(sb.toString());
                    rcount--;
                }else if(lcount>n){
                    lcount--;
                    sb.deleteCharAt(sb.length()-1);
                    continue;
                }else{
                    rcount--;
                    sb.deleteCharAt(sb.length()-1);
                    continue;
                }
            }else if(rcount>lcount){
                rcount--;
            }else if(lcount>n){
                lcount--;
                sb.deleteCharAt(sb.length()-1);
                continue;
            }else{
                fun(list,sb,origin,lcount,rcount,n);
                if(flag)
                    lcount--;
                else
                    rcount--;
            }
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis g= new GenerateParenthesis();
        List<String> result = g.generateParenthesis(3);
        System.out.println();
    }


}
