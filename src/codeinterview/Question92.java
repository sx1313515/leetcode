package codeinterview;

import java.util.Scanner;

/**
 * 描述:
 * 给定数组arr，arr[i]==k代表可以从位置向右跳1~k个距离。比如，arr[2]==3,代表可以从位置2跳到位置3、位置4或位置5。如果从位置0出发，返回最少跳几次能跳到arr最后的位置上。
 * @Author: xiang_song
 * @CreateDate: 2021/3/17 10:07 下午
 */
public class Question92 {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n;i++){
            a[i] = sc.nextInt();
        }
        int sum = 0;
        int index = 0;
        while(index < n -1) {
            int length = a[index];
            int max = 0;
            int cur = 0;
            for(int i = index+1;i<=index+length;i++){
                if(i == n-1){
                    System.out.println(++sum);
                    return;
                }
                if(a[i]+i > max) {
                    max = a[i]+i;
                    cur = i;
                }
            }
            sum ++;
            index = cur;
        }
        System.out.println(sum);
    }
}
