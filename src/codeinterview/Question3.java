package codeinterview;

import java.util.Scanner;
public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int k = sc.nextInt();
            for(int i = 0;i < n;i++) {
                a[i] = sc.nextInt();
            }
            int left = 0,right = n-1;
            while(left < right){
                if(left - 1 >= 0 && a[left] == a[left-1]){
                    left ++;
                    continue;
                }
                if(right+1 <= n-1  && a[right] == a[right+1]){
                    right --;
                    continue;
                }
                if(a[left] + a[right] == k){
                    System.out.println(a[left]+" "+a[right]);
                    left++;
                    right--;
                } else if(a[left] + a[right] < k){
                    left++;
                } else {
                    right--;
                }
            }

        }
    }
}