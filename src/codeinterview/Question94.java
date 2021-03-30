package codeinterview;

import java.util.Scanner;

/**
 * 描述:n皇后问题
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/18 8:54
 */
public class Question94 {
    public static boolean[] col;
    public static boolean[] dia1;
    public static boolean[] dia2;
    private static int sum;
    public static void PutQueen(int n,int row)
    {
        if(row==n)
        {
            sum ++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if(!col[j]&&!dia1[j+row]&&!dia2[row-j+n-1])
                //左下到右上的所有斜线，每条斜线上的数据行加列都是相等的，如果等于同一个值就表名在同一斜线上
                //左上到右下的所有斜线，每条斜线上的数据行-列+总数+1都是相等的，如果等于同一个值就表名在同一斜线上
            {
                col[j] = true;
                dia1[j+row] = true;
                dia2[row-j+n-1] = true;
                PutQueen(n, row+1);
                col[j] = false;
                dia1[j+row] = false;
                dia2[row-j+n-1] = false;
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            int n = sc.nextInt();
            col = new boolean[n];  //存储改列上是否有皇后，一共n列
            dia1 = new boolean[2*n-1];  //存储左下到右上是否有皇后，一共2n-1斜线
            dia2 = new boolean[2*n-1];  //存储左上到右下是否有皇后，一共2n-1斜线
            PutQueen(n,0);
            System.out.println(sum);
        }


    }
}
