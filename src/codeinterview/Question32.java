package codeinterview;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 描述:数组中子数组的最大累乘积
 * 给定一个double类型的数组arr，其中的元素可正、可负、可0，返回子数组累乘的最大乘积。例如，arr=[-2.5, 4, 0, 3, 0.5, 8, -1]，子数组[3, 0.5, 8]累乘可以获得最大的乘积12，所以返回12
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 * @Author: xiang_song
 * @CreateDate: 2021/3/2 9:01 下午
 */
public class Question32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] a = new double[n];
        for(int i = 0;i < n;i++) {
            a[i] = sc.nextDouble();
        }
        double min = a[0];
        double max = a[0];
        double result = a[0];
        if(n == 1){
            System.out.println(result);
            return;
        }
        for(int i = 1;i < n;i++) {
            double minTemp = a[i]*min;
            double maxTemp = a[i]*max;
            min = Math.min(Math.min(minTemp,maxTemp),a[i]);
            max = Math.max(Math.max(minTemp,maxTemp),a[i]);
            result = Math.max(result,max);
        }
        DecimalFormat format = new DecimalFormat("0.00");
        System.out.println(format.format(result));
    }
}
