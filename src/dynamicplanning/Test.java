package dynamicplanning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public int threeSumClosest(int[] num,int target) {
        Arrays.sort(num);
        int length = num.length;
        int m,n;
        int min = Integer.MAX_VALUE;
        int result=num[0]+num[1]+num[2];
        for(int i=0;i<length-2;i++){
            m = i + 1;
            n = length-1;
            while (m<n){
                if(num[m]+num[n]+num[i]==target){
                    return target;
                }else if (num[m]+num[n]+num[i]>target){
                    if(min>Math.abs(num[m]+num[n]+num[i]-target)){
                        min = Math.abs(num[m] + num[n] + num[i] - target);
                        result = num[m] + num[n] + num[i];
                    }
                    n--;
                }else {
                    if(min>Math.abs(num[m]+num[n]+num[i]-target)){
                        min = Math.abs(num[m] + num[n] + num[i] - target);
                        result = num[m] + num[n] + num[i];
                    }
                    m++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(threeSumClosest(new int[]{2,3,4,5},new int[]{}));;
    }
}

