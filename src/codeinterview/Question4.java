package codeinterview;

import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int k = sc.nextInt();
            for(int i = 0;i < n;i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                if (i > 0 && a[i] == a[i - 1]) {
                    continue;
                }
                int left = i+1,right = n-1;
                while(left < right && left < n){
                    if(left - 1 >= i && a[left] == a[left-1]){
                        left ++;
                        continue;
                    }
                    if(right+1 <= n-1  && a[right] == a[right+1]){
                        right --;
                        continue;
                    }
                    if(a[left] + a[right] == k - a[i]){
                        System.out.println(a[i] + " "+a[left]+" "+a[right]);
                        left++;
                        right--;
                    } else if(a[left] + a[right] < k-a[i]){
                        left++;
                    } else {
                        right--;
                    }
                }
            }


        }
    }
}