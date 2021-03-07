package codeinterview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 描述:最长递增子序列
 *
 * @Author: xiang_song
 * @CreateDate: 2021/2/27 6:29 下午
 */
public class Question25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] memo = new int[n];
        Arrays.fill(memo,1);
        int[] a = new int[n];
        Map<Integer, String> map = new HashMap<>(16);
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            map.put(i,String.valueOf(a[i])+" ");
        }
        for (int i=1;i<n;i++){
          for (int j=0;j<i;j++){
              if (a[i]>a[j]) {
                  if (1+memo[j] >= memo[i]) {
                      memo[i] = 1+memo[j];
                      map.put(i,map.get(j)+a[i]+" ");
                  }
              }
          }
        }
        int max = memo[0];
        String result = map.get(0);
        for (int i =1;i<n;i++){
            if (memo[i]>=max){
                max = memo[i];
                result = map.get(i);
            }
        }
        System.out.println(result);
    }


}
