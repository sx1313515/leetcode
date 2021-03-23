package codeinterview;
//给定一个个数字arr，判断数组arr中是否所有的数字都只出现过一次。
//通过建堆的过程来判断是否有重复的元素
import java.util.*;
public class Question103 {
    //构建一个堆
    public static boolean make_heap(int[] a,int n)
    {
        //把第0个元素放到第n个，因为堆的元素从1开始
        a[n] = a[0];
        for(int i=n/2;i>=1;i--){
            if(!sift_down(a, n, i)) {
                return false;
            }
        }
        return true;
    }
    //元素下移操作,第i个元素
    public static boolean sift_down(int[] a,int n,int i)
    {
        boolean flag = false;
        if((2*i)<=n)
        {
            while(!flag&&(i=2*i)<=n)
            {

                if((i+1)<=n)
                {
                    if (a[i / 2] == a[i] || a[i / 2] == a[i + 1] || a[i] == a[i+1]) {
                        return false;
                    }
                    if (a[i + 1] > a[i]) {
                        i = i +1;
                    }
                }
                if(a[i/2]<a[i]){
                    int temp = a[i];
                    a[i] = a[i/2];
                    a[i/2] = temp;
                }else if(a[i/2]>a[i]){
                    flag = true;
                } else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        boolean result = make_heap(arr,n);
        System.out.println(result ? "YES":"NO");
    }
}