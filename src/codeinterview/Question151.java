package codeinterview;

import java.util.Scanner;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/26 6:01 上午
 */
public class Question151 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                System.out.print(nums[0][i]+" ");
            }
            return;
        }
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                System.out.print(nums[i][0]+" ");
            }
            return;
        }
        for (int i = 0; i < (m+n)/2; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print((i%2 == 1 ? nums[j][i-j] : nums[i-j][j])+" ");
            }
        }
        for (int i = (m+n)/2; i < m+n-1; i++) {
            for (int j = Math.min(m,n)-1; j > (Math.min(m,n)-m-n+i); j--) {
                System.out.print((i%2 == 0 ? nums[j][i-j] : nums[i-j][j])+" ");
            }
        }
    }
}
