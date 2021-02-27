package codeinterview;

import java.util.Scanner;

/**
 * 描述:
 *题目描述
 * 给定一个N \times MN×M的整形矩阵matrix和一个整数K, matrix的每一行和每一列都是排好序的。
 * 实现一个函数，判断K是否在matrix中
 * [要求]
 * 时间复杂度为O(N+M)O(N+M)，额外空间复杂度为O(1)O(1)。
 * 输入描述:
 * 第一行有三个整数N, M, K
 * 接下来N行，每行M个整数为输入的矩阵
 * 输出描述:
 * 若K存在于矩阵中输出"Yes"，否则输出"No"
 * 示例1
 * 输入
 * 复制
 * 2 4 5
 * 1 2 3 4
 * 2 4 5 6
 * 输出
 * 复制
 * Yes
 * 示例2
 * 输入
 * 复制
 * 2 4 233
 * 1 2 3 4
 * 2 4 5 6
 * 输出
 * 复制
 * No
 * 备注:
 * 1 \leqslant N, M \leqslant 10001⩽N,M⩽1000
 * 0 \leqslant K, \text{矩阵中的数} \leqslant 10^90⩽K,矩阵中的数⩽10
 * 9
 *
 * @Author: xiang_song
 * @CreateDate: 2021/2/2 8:42 下午
 */

/**
 * 假设矩阵从左到右，从上倒下都是递增的，虽然题目没说，
 * 从右上角开始，比k小的肯定在左边，比k大的肯定在下面，直接找到为止
 */
public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int a[][] = new int[n][m];
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            int row = 0,index = m-1;
            while(row < n && index > -1) {
                if(a[row][index] == k){
                    System.out.println("Yes");
                    return;
                } else if(a[row][index] > k){
                    index--;
                } else{
                    row++;
                }
            }
            System.out.println("No");
        }
    }
}
