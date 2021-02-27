package codeinterview;

import java.util.ArrayList;
import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String n = sc.nextLine();
            ArrayList<Integer> list = new ArrayList(16);
            for(int i = 0;i < Integer.valueOf(n);i++) {
                String input1 = sc.nextLine();
                if(input1.contains("push")){
                    String[] splits = input1.split(" ");
                    list.add(Integer.valueOf(splits[1]));
                } else if (input1.equals("pop")){
                    list.remove(list.size()-1);
                } else if (input1.equals("getMin")){
                    int result = Integer.MAX_VALUE;
                    for(Integer l : list) {
                        result = Math.min(result,l);
                    }
                    System.out.println(result);
                }
            }
        }
}