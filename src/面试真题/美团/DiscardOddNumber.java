package 面试真题.美团;

import java.util.Scanner;

/*
 * 对于一个由0..n的所有数按升序组成的序列，
 * 我们要进行一些筛选，
 * 每次我们取当前所有数字中从小到大的第奇数位个的数，
 * 并将其丢弃。重复这一过程直到最后剩下一个数。
 * 请求出最后剩下的数字。
 */
public class DiscardOddNumber {
	public static int result(int n)
	{
		int j=0,t;
		int s=n+1;
		int[] a = new int[n+1];
		for(int i=0;i<n+1;i++)
			a[i]=i;
		while(j<n)
		{
			t=s; 
			s=0;
			for(int i=0;i<t;i++)
			{
				if((i+1)%2==0)
				{
					a[s++]=a[i];
				}
				else
				{
					j++;
				}
			}
		}
		return a[0];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int n;
			n = sc.nextInt();
			System.out.println(result(n));
		}

	}
}
