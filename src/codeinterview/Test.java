package codeinterview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2021/2/27 2:49 下午
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (n==1){
            System.out.println(0);
            return;
        }
        int sum = 0;
        for (int i=1;i<n;i++){
            int sum1 = 0;
            for (int j = 0;j<i;j++){
                if (a[j]<a[i]){
                    sum1+=a[j];
                }
            }
            sum += sum1;
        }
        System.out.println(sum);
    }

    public int coins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }
    public int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }
    public int process2(int[] a,int index,int aim){
        int res = 0;

        for (int i = 0; i * a[index] <= aim; i++) {
            res = res + process2(a, index, aim - i * a[index]);
        }
        return res;
    }
}
