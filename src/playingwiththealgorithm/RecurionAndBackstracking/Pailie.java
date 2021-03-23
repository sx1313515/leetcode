package playingwiththealgorithm.RecurionAndBackstracking;

import java.util.ArrayList;
import java.util.Arrays;
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
		Arrays.fill(used, false);
		list = new ArrayList<ArrayList<Integer>>(); 
		ArrayList<Integer> perlist = new ArrayList<>();
		fun1(nums,0,perlist);
		for(int i=0;i<list.size();i++)
		{
			for(int j=0;j<list.get(i).size();j++)
			{
				System.out.print(list.get(i).get(j)+" ");
			}
			System.out.println();
			//System.out.println(i);
		}
	}
	public static void fun1(int[] nums,int index,ArrayList<Integer> p)
	{
		if(index==nums.length)
		{
			ArrayList<Integer> perlist = new ArrayList<>();
			for(int j=0;j<p.size();j++)
			{
				perlist.add(p.get(j));
			}
			list.add(perlist);
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
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4};
		fun(a);
	}

}
