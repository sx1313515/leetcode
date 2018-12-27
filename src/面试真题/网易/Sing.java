package 面试真题.网易;
/*
小Q和牛博士合唱一首歌曲,这首歌曲由n个音调组成,每个音调由一个正整数表示。
对于每个音调要么由小Q演唱要么由牛博士演唱,对于一系列音调演唱的难度等于所有相邻音调变化幅度之和, 例如一个音调序列是8, 8, 13, 12, 那么它的难度等于|8 - 8| + |13 - 8| + |12 - 13| = 6(其中||表示绝对值)。
现在要对把这n个音调分配给小Q或牛博士,让他们演唱的难度之和最小,请你算算最小的难度和是多少。
如样例所示: 小Q选择演唱{5, 6}难度为1, 牛博士选择演唱{1, 2, 1}难度为2,难度之和为3,这一个是最小难度和的方案了
 */
import java.util.Scanner;

public class Sing {
	public static long fun(int[] a)
	{
		int size = a.length;
		int[] cost = new int[size];
		for(int i=1;i<size;i++)
			cost[i] = Math.abs(a[i]-a[i-1]);
		long[][] dp = new long[size][size];
		for(int i=2;i<size;i++)
			dp[i][i-1] = dp[i-1][i-2] + cost[i-1];
		for (int i = 2; i < size; i++) 
		{
	        for (int j = 0; j < i - 1; j++) 
	        {
	            dp[i][j] = dp[i - 1][j] + cost[i];
	            dp[i][i-1] = Math.min(dp[i][i - 1],dp[i-1][j] + Math.abs(a[i] - a[j]));
	        }
		}
		long result = Long.MAX_VALUE;
		for(int i=0;i<size-1;i++)
			result = Math.min(result,dp[size-1][i]);
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i=0;i<a.length;i++)
				a[i] = sc.nextInt();
			System.out.println(fun(a));
		}
	}
}

