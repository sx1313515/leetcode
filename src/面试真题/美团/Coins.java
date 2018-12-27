package 面试真题.美团;

import java.util.Scanner;

public class Coins {
	static int[] memo;
	public static int fun1(int n)
	{
		memo = new int[n+1];
		for(int i=0;i<memo.length;i++) {
			memo[i] = -1;
		}
		return fun(n);
	}
	//动态规划形式
	public static int fun2(int n)
	{
		int[] memo1 = new int[n+1];
		memo1[0] = 1;
		memo1[1] = 1;
		for(int i=2;i<=n;i++)
		{
			memo1[i] = memo1[i-1]+memo1[i-2];
		}
		return memo1[n];
	}
	//递归加记忆搜索形式
	public static int fun(int n)
	{
		if(n==1)
			return 1;
		else if(n==2)
			return 2;
		else
			if(memo[n]==-1)
				memo[n] = fun(n-1)+fun(n-2);
			return memo[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int s = sc.nextInt();
			System.out.println(fun2(s));
		}
	}

}
