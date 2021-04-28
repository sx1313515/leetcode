package codeinterview;

/**
 * 描述:分糖果问题
 * 一群孩子做游戏，现在请你根据游戏得分来发糖果，要求如下：
 * 1. 每个孩子不管得分多少，起码分到一个糖果。
 * 2. 任意两个相邻的孩子之间，得分较多的孩子必须拿多一些糖果。(若相同则无此限制)
 * 给定一个数组arr代表得分数组，请返回最少需要多少糖果。
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
        int[] memo = new int[n]; //每个小孩当前的糖果
        Arrays.fill(memo,1);
        int sum = n;  //每人至少一个糖果，所以周少n个
        for(int i = 1;i < n;i++){  //从左到右
            if(a[i] > a[i-1]){
                sum += memo[i-1]+1-memo[i];  // memo[i-1]+1表示需要多少糖果，减去memo[i]表示加了多少糖果
                memo[i] = memo[i-1] + 1;  //当前小孩的糖果数
            }
        }
        for(int i = n-2;i >= 0;i--){  //从右到左
            if(a[i] > a[i+1] && memo[i] <= memo[i+1]){
                sum += memo[i+1]+1-memo[i]; // memo[i-1]+1表示需要多少糖果，减去memo[i]表示加了多少糖果
                memo[i] = memo[i+1] + 1; //当前小孩的糖果数
            }
        }
        System.out.println(sum);
    }

}
