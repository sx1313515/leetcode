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
        String str = "02";
        System.out.println(1 ^ 0);

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
