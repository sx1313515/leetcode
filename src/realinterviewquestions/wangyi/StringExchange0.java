package realinterviewquestions.wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringExchange0 {
	public static List<Integer> fun(int n)
	{
		List<Integer> left = new ArrayList<Integer>();
		if(n==1)
		{
			left.add(1);
			return left;
		}
		if(n==2)
		{
			left.add(2);
			left.add(1);
			return left;
		}
		int n0 = n;
		while(n0!=2&&n0!=3)
		{
			left.add(n0);
			n0 = n0-2;
		}
		left.add(n0);
		left.add(1);
		if(left.get(left.size()-2)==2)
		{
			int right = 3;
			while(right<=n-1)
			{
				left.add(right);
				right = right+2;
			}
		}
		else
		{
			int right = 2;
			while(right<=n-1)
			{
				left.add(right);
				right = right+2;
			}
		}
		return left;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int n = sc.nextInt();
			int[] memo = new int[n];
			for(int i=0;i<n;i++)
				memo[i] = sc.nextInt();
			List<Integer> list = new ArrayList<>();
			list = fun(n);
			for(int i=0;i<list.size()-1;i++)
				System.out.print(memo[list.get(i)-1]+" ");
			System.out.print(memo[list.get(list.size()-1)-1]);
		}
	}

}
