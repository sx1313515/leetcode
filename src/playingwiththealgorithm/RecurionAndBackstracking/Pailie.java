package playingwiththealgorithm.RecurionAndBackstracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * 给定一组不相同的数，输出所有排列的情况
 */
public class Pailie {
	static List<ArrayList<Integer>> list;
	static boolean[] used;
	public static void fun(int[] nums)
	{
		int size = nums.length;
		used = new boolean[size];
		list = new ArrayList<>();
		ArrayList<Integer> perlist = new ArrayList<>();
		fun1(nums,0,perlist);
		HashSet<String> set = new HashSet<>();
	}
	public static void fun1(int[] nums,int index,ArrayList<Integer> p)
	{
		if(index==nums.length)
		{
			list.add(new ArrayList<>(p));
			return;
		}
		for(int i=0;i<nums.length;i++)
		{
			if(!used[i])
			{
				used[i] = true;
				p.add(nums[i]);
				fun1(nums,index+1,p);
				p.remove(p.size()-1);
				used[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4};
		fun(a);
	}

}
