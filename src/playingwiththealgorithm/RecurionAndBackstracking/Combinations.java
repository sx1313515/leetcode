package playingwiththealgorithm.RecurionAndBackstracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 给定一组不相同的数，输出所有组合的情况
 */
public class Combinations {
	static List<ArrayList<Integer>> list;
	public static void fun(int n,int k)
	{
		list = new ArrayList<ArrayList<Integer>>(); 
		ArrayList<Integer> perlist = new ArrayList<>();
		fun1(n,k,1,perlist);
		for(int i=0;i<list.size();i++)
		{
			for(int j=0;j<list.get(i).size();j++)
			{
				System.out.print(list.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
	public static void fun1(int n,int k,int start,ArrayList<Integer> p)
	{
		if(k==0)
		{
			ArrayList<Integer> perlist = new ArrayList<>();
			for(int j=0;j<p.size();j++)
			{
				perlist.add(p.get(j));
			}
			list.add(perlist);
			return;
		}
		for(int i=start;i<=n;i++)
		{
				p.add(i);
				fun1(n,k-1,i+1,p);
				p.remove(p.size()-1);
		}
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			fun(n, k);
		}
	}

}
