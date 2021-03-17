package codeinterview;

/**
 * 描述:分糖果问题
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/13 2:27 下午
 */
import java.util.*;
public class Question77 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n;i++){
            a[i] = sc.nextInt();
        }
        int[] memo = new int[n];
        Arrays.fill(memo,1);
        int sum = n;
        for(int i = 1;i < n;i++){
            if(a[i] > a[i-1]){
                sum += memo[i-1]+1-memo[i];
                memo[i] = memo[i-1] + 1;
            }
        }
        for(int i = n-2;i >= 0;i--){
            if(a[i] > a[i+1] && memo[i] <= memo[i+1]){
                sum += memo[i+1]+1-memo[i];
                memo[i] = memo[i+1] + 1;
            }
        }
        System.out.println(sum);
    }

}
