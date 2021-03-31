package playingwiththealgorithm.RecurionAndBackstracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 给定一组不相同的数，输出所有组合的情况
 */
public class Combinations {
	static List<ArrayList<Integer>> list = new ArrayList<>();
	public static void fun(int n,int k,int[] nums)
	{
		ArrayList<Integer> perlist = new ArrayList<>();
		dfs(nums,n,k,0,perlist);  //n表示总元素数量，k表示选出元素的个数
	}
	public static void dfs(int[] nums,int n,int k,int start,ArrayList<Integer> p)
	{
		if(k==0) //k为0表示元素都取好了，跟排列一样的
		{
			list.add(new ArrayList<>(p));
			return;
		}
		for(int i=start;i<n;i++) //为什么这里不需要userd,因为组合每次都是选剩下的元素，选过的元素不会再选了
		{
				p.add(nums[i]);
				dfs(nums,n,k-1,i+1,p);  //k不需要回溯因为k在当前堆栈的值没变,start加1因为从剩下的元素里面选
				p.remove(p.size()-1); //回溯
		}
		return;
	}

}
