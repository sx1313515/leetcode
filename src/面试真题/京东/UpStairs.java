package 面试真题.京东;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 有一楼梯共m级，刚开始时你在第一级，
 * 若每次只能跨上一级或者二级，要走上m级，
 * 共有多少走法？注：规定从一级到一级有0种走法。
给定一个正整数int n，请返回一个数，代表上楼的方式数。
保证n小于等于100。为了防止溢出，请返回结果Mod 1000000007的值。
 */
public class UpStairs {
	static long[] memo;
	public static long fun(int n)
	{
		if(memo[n]!=-1)
			return memo[n];
		memo[n] = (fun(n-1)+fun(n-2));
		return (fun(n-1)+fun(n-2));
	}
	public static long climbStairs(int n)
	{
		if(n==1)
			return 1;
		int m = n-1;
		memo = new long[n];
		Arrays.fill(memo, -1);
		memo[0] = 1;
		memo[1] = 2;
		return fun(m);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int n = sc.nextInt();
			System.out.println(climbStairs(n));
		}
	}

}
