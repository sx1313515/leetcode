package 面试真题.腾讯;

import java.util.Scanner;

public class geohashCode {
	public static String fun(int n)
	{
		int low = -90;
		int high = 90;
		String s = "";
		while(low<high)
		{
			int mid = (low+high)/2;
			if(mid==n)
			{
				if(Math.abs(mid-low)<Math.abs(mid-high))
					return s+"0";
				else
					return s;
			}
			else if(mid<n)
			{
				low = mid;
				s = s+"1";
			}
			else
			{
				high = mid-1;
				s = s+"0";
			}
		}
		return s;
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
