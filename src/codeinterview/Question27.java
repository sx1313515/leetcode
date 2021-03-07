package codeinterview;

import java.util.Scanner;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2021/2/28 2:54 下午
 */
public class Question27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        int max = Integer.MIN_VALUE;
        int lineMax = Integer.MIN_VALUE;
        int[] temp;
        for (int i=0;i<n;i++) {
            temp = new int[m];
            for (int j =i;j<n;j++){
                int cur = 0;
                for (int k=0;k<m;k++){
                    temp[k] = temp[k] + a[j][k];
                    cur = cur + temp[k];
                    lineMax = Math.max(lineMax, cur);
                    if (cur < 0){
                        cur = 0;
                    }
                }
                max = Math.max(max, lineMax);

            }
        }
        System.out.println(max);
    }
}
