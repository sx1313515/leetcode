package realinterviewquestions.jianzhioffer;

import java.util.Arrays;

/*
 * 输入数字n，按顺序打印从1到最大的n为十进制数。比如输入3，
 * 则打印1、2、3一直到最大的3位数即999
 * 
 */
public class Print1ToN {
	static int[] a;
	public static void fun(int n)
	{
		a = new int[n];
		Arrays.fill(a, 0);
		for(int i=0;i<10;i++)
		{
			a[0] = i;
			print1(a,n,0);
		}
	}
	public static void print1(int[] a,int length,int index)
	{
		if(index==length-1)
		{
			print2(a);
			return;
		}
		for(int i=0;i<10;i++)
		{
			a[index+1] = i;
			print1(a,length,index+1);
		}
		
	}
	public static void print2(int[] a)
	{
		int i=0;
		while(a[i]==0)
		{
		  i++;
		  if(i==a.length)
		  {
			  System.out.println(0);
			  return;
		  }
		}
		for(int j=i;j<a.length;j++)
			System.out.print(a[j]);
		System.out.println();
	}
	public static void main(String[] args) {
		int n = 100;
		fun(n);
	}
}
