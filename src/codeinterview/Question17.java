package codeinterview;

import java.util.*;

/**
 * 假设有排成一行的N个位置，记为1~N，开始时机器人在M位置，机器人可以往左或者往右走，如果机器人在1位置，那么下一步机器人只能走到2位置，如果机器人在N位置，那么下一步机器人只能走到N-1位置。规定机器人只能走k步，最终能来到P位置的方法有多少种。由于方案数可能比较大，所以答案需要对1e9+7取模。
 * 机器人达到指定位置方法数
 */
public class Question17 {
    private static long[][] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int P = sc.nextInt();
        if( N < 2 || M <1 || K < 1||P<1){
            System.out.println(0);
            return;
        }
        memo = new long[N+1][K+1];
        for (long[] temp: memo){
            Arrays.fill(temp, -1);
        }
        long result = fun(N,M,K,P);
        System.out.println(result%1000000007);
    }
    public static long fun(int N,int M,int K,int P){
        if(memo[M][K] != -1){
            return memo[M][K];
        }
        if((K-Math.abs(P-M))%2 == 1){
            return 0;
        }
        if(K < Math.abs(P-M)){
            return 0;
        }
        if(K == 0){
            return M == P ? 1 : 0;
        }
        if(M==1){
            memo[M+1][K-1] = fun(N,M+1,K-1,P)%1000000007;
            return memo[M+1][K-1];
        }
        if(M==N){
            memo[M-1][K-1] = fun(N,M-1,K-1,P)%1000000007;
            return memo[M-1][K-1];
        }
        memo[M][K] = fun(N,M-1,K-1,P)+fun(N,M+1,K-1,P)%1000000007;
        return memo[M][K];
    }
}