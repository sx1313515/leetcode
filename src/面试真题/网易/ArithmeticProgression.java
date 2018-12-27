package 面试真题.网易;

import java.util.Scanner;

/*
 * 如果一个数列S满足对于所有的合法的i,都有S[i + 1] = S[i] + d, 
 * 这里的d也可以是负数和零,我们就称数列S为等差数列。
小易现在有一个长度为n的数列x,小易想把x变为一个等差数列。
小易允许在数列上做交换任意两个位置的数值的操作,并且交换操作允许交换多次。
但是有些数列通过交换还是不能变成等差数列,
小易需要判别一个数列是否能通过交换操作变成等差数列 
 */
public class ArithmeticProgression {
	public static boolean IsArithmeticProgression(int[] a)
	{
		int cha = a[1]-a[0];
		for(int i=2;i<a.length;i++)
			if(a[i]-a[i-1]!=cha)
				return false;
		return true;
	}
	public static int fun1(int[] a,int low,int high)
	{
		int p = a[low];
		while(low<high)
		{
			while(low<high&&a[high]>=p)
				high--;
			a[low] = a[high];
			while(low<high&&a[low]<=p)
				low++;
			a[high] = a[low];
		}
		a[low] = p;
		return low;
	}
	public static void quick_sort(int[] a,int low,int high)
	{
		if(low<high)
		{
			int p = fun1(a, low, high);
			quick_sort(a, low, p-1);
			quick_sort(a, p+1, high);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int  n = sc.nextInt();
			int[] a = new int[n];
			for(int i=0;i<a.length;i++)
				a[i] = sc.nextInt();
			quick_sort(a,0,a.length-1);
			if(IsArithmeticProgression(a))
				System.out.println("Possible");
			else
				System.out.println("Impossible");
		}
	}

}
