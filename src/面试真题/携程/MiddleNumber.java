package 面试真题.携程;

import java.util.Scanner;

public class MiddleNumber {
	public static void merge(int[] a,int m,int n,int k)
	{
		int[] memo = new int[k-m+1];
		int i=m; int j=n+1; int s=0;
		while(i<=n&&j<=k)
		{
			if(a[i]<=a[j])
				memo[s++] = a[i++];
			else
				memo[s++] = a[j++];
		}
		if(i>n)
			while(j<=k)
				memo[s++] = a[j++];
		if(j>k)
			while(i<=n)
				memo[s++] = a[i++];
		for(int p=0;p<=k-m;p++)
		{
			a[m+p] = memo[p];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int m = sc.nextInt();
			int[] b = new int[m];
			for(int i=0;i<m;i++)
				b[i] = sc.nextInt();
			int s = n+m;
			int[] v = new int[s];
			for(int i=0;i<n;i++)
				v[i] = a[i];
			for(int i=0;i<m;i++)
				v[n+i] = b[i];
			merge(v,0,n-1,s-1);
			if(s%2==0)
				System.out.println(Float.parseFloat(String.valueOf((v[s/2]+v[s/2-1])))/2);
			else
				System.out.println(v[s/2]);
		}
	}

}
