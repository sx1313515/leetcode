package 面试真题.美团;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 给你六种面额 1、5、10、20、50、100 元的纸币，
 * 假设每种币值的数量都足够多，编写程序求组成N元（N为0~10000的非负整数）
 * 的不同组合的个数。 
 */
public class MoneyCombine {
	public static long fun(int n)
	{
		int[] coins = {1,5,10,20,50,100};
		long[] memo = new long[n+1];
		Arrays.fill(memo, 0);
		memo[0] = 1;
		for(int i=0;i<coins.length;i++)
		{
			for(int j=coins[i];j<=n;j++)
			{
				memo[j] = memo[j]+memo[j-coins[i]];
			}
		}
		return memo[n];
		
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
