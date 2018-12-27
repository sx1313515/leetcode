package 面试真题.今日头条;

import java.util.Scanner;

public class ToutiaoCampus {
	public static int fun(int[] a,int n)
	{
		int s = n%3;
		if(s==0)
			return 0;
		else
			return 3-s;
				
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
		while(sc.hasNext())
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			System.out.println(fun(a, n));
		}
	}

}
