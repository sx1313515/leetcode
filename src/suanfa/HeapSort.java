package suanfa;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2020/7/5 8:01 上午
 */
import java.util.Scanner;

public class HeapSort {

    //元素上移操作,第i个元素
    public static void sift_up(int[] a,int i)
    {
        boolean flag = false;
        if(i>1)
        {
            while(!flag&&i>1)
            {
                if(a[i]>a[i/2])
                {
                    int temp = a[i];
                    a[i] = a[i/2];
                    a[i/2] = temp;
                }
                else
                    flag = true;
                i = i/2;
            }
        }
    }
    //元素下移操作,第i个元素
    public static void sift_down(int[] a,int n,int i)
    {
        boolean flag = false;
        if((2*i)<=n)
        {
            while(!flag&&(i=2*i)<=n)
            {
                if((i+1)<=n&&a[i+1]>a[i])
                {
                    i = i +1;
                }
                if(a[i/2]<a[i])
                {
                    int temp = a[i];
                    a[i] = a[i/2];
                    a[i/2] = temp;
                }
                else
                    flag = true;
            }
        }
    }
    //构建一个堆
    public static void make_heap(int[] a,int n)
    {
        //把第0个元素放到第n个，因为堆的元素从1开始
        a[n] = a[0];
        for(int i=n/2;i>=1;i--)
            sift_down(a, n, i);
    }
    //就地堆排序
    public static void heap_sort(int[] a,int n)
    {
        make_heap(a, n);
        for(int i=n;i>=1;i--)
        {
            int temp = a[i];
            a[i] = a[1];
            a[1] = temp;
            sift_down(a, i-1,1);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            int n = sc.nextInt();
            int[] a = new int[n+1];
            for(int i=0;i<n;i++)
            {
                a[i] = sc.nextInt();
            }
            heap_sort(a, n);
            for (int i=1;i<=n;i++) {
                System.out.print(a[i]+" ");
            }
        }
    }

}
