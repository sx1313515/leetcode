package realinterviewquestions.tencent;

import java.util.Scanner;

public class PrimeNumberPairs {
	public static int fun(int n)
	{
		if(n<=3)
			return 0;
		int sum = 0;
		for(int i=2;i<=n/2;i++)
		{
			if(isprime(i)&&isprime(n-i))
				sum++;
		}
		return sum;
	}
	//判断是否是质数
	public static boolean isprime(int n)
	{
		if(n==0||n==1)
			return false;
		for(int j=2;j<n;j++)
			if(n%j==0)
				return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
				int n = sc.nextInt();
				System.out.println(fun(n));
		}
	}

}
