package 玩转算法.DynamicProgramming;

import java.util.Arrays;

/*
 * 给定一个整数序列，求其中的最长上升子序列的长度
 */
public class LongestIncreasingSubsequence {
	//递归算法
	public static int fun1(int[] nums,int index)
	{
		if(index<0)
			return 0;
		if(memo[index]!=-1)
			return memo[index];
		int res = 1;
		for(int i=index-1;i>=0;i--)
		{
			if(nums[index]>nums[i])
				res = Math.max(1+fun1(nums,i),res);
		}	
		memo[index] = res;
		return res;
		
	}
	//动态规划算法     
	public static int fun3(int[] nums) {
		int size = nums.length;
		if(size==0)
			return 0;
		int[] memo = new int[size];
		Arrays.fill(memo, 1);
		for (int i = 1; i < size; i++) {
			for(int j=0;j<i;j++)
			{
			  if(nums[i]>nums[j])
				  memo[i] = Math.max(memo[i], 1+memo[j]);
			}
		}
		int res = 0;
		for(int i=0;i<size;i++)
			res = Math.max(res, memo[i]);
		return res;
	}
	static int[] memo;
	public static int fun2(int[] nums)
	{
		int size = nums.length;
		memo = new int[size];
		Arrays.fill(memo, -1);
		if(size==0)
			return 0;
		int res = 1;
		for(int i=0;i<size;i++)
			res = Math.max(res, fun1(nums,i));
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int w[] = {1, 3, 6, 7, 9, 4, 10, 5, 6}; // 6
//		 Arrays.sort(w);
//		 for (int i=0;i<w.length;i++)
//			System.out.print(w[i]+" ");
		System.out.println(fun3(w));;
	}

}
