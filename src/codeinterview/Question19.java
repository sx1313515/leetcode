package codeinterview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 换钱的方法数
 * 给定数组arr，设数组长度为n，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim，代表要找的钱数，求换钱的方法数有多少种。由于方法的种数比较大，所以要求输出对10^9+710
 * 9+7进行取模后的答案。
 */
    public class Question19 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] memo = new int[k+1];
            memo[0] = 1;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            Arrays.sort(a);
            if(n==1){
                System.out.println(k%a[0]==0?1:0);
                return;
            }
            for(int i=1;i<=k;i++){
                if(i>=a[0] && i%a[0]==0){
                    memo[i] = 1;
                }
            }
            for(int i=1;i<n;i++){
                for(int j = a[i];j<=k;j++){
                    memo[j] = (memo[j]+memo[j-a[i]])%1000000007;
                }
            }
            System.out.println(memo[k]);

        }

    }

