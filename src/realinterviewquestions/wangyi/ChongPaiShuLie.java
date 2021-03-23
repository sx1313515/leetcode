package realinterviewquestions.wangyi;
/*
 * 
小易有一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}。
牛博士给小易出了一个难题:
对数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)
都是4的倍数。
小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。
 */
import java.util.Scanner;

public class ChongPaiShuLie {
	static boolean[] used;
	public static void fun(int[] a)
	{
		int countmod4 = 0;
		int countnomod = 0;
		int size = a.length;
		for(int i=0;i<size;i++)
		{
			if(a[i]%4==0)
				countmod4++;
			if(a[i]%2!=0)
				countnomod++;
		}
		if(countmod4>=countnomod)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int count = sc.nextInt();
			for(int i=0;i<count;i++)
			{
				int n = sc.nextInt();
				int[] a = new int[n];
				for(int j=0;j<n;j++)
					a[j] = sc.nextInt();
				fun(a);
			}
		}
	}

}
