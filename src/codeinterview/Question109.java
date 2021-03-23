package codeinterview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 描述:猴子报数选大王
 *据说著名犹太历史学家 Josephus 有过以下故事：在罗马人占领乔塔帕特后，39 个犹太人与 Josephus 及他的朋友躲到一个洞中，39 个犹太人决定宁愿死也不要被敌人抓到，于是决定了一种自杀方式，41 个人排成一个圆圈，由第 1 个人开始报数，报数到 3 的人就自杀，然后再由下一个人重新报 1，报数到 3 的人再自杀，这样依次下去，直到剩下最后一个人时，那个人可以自由选择自己的命运。这就是著名的约瑟夫问题。现在请用单向环形链表得出最终存活的人的编号。
 * @Author: xiang_song
 * @CreateDate: 2021/3/20 4:34 下午
 */
public class Question109 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        Arrays.fill(arr,1);
        int index = 0;
        int count = 0;
        while (n != 1) {
            if (arr[index] == 1) {
                count++;
                if (count == m) {
                    count = 0;
                    arr[index] = 0;
                    n--;
                }
            }
            index = (index + 1)%arr.length;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                System.out.println(i+1);
            }
        }
    }
}
