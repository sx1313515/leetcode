package 面试真题.网易;

import java.util.Scanner;

public class StringExchange {
	public static void fun(int n)
	{
		String s = "1_a";
		if(n==1)
			System.out.println(s);
		else
		{
			for(int i=2;i<=n;i++)
			{
				s = s+"a_"+i;
				s = change(s);
			}
			System.out.println(s);
		}
	}
	public static String change(String s)
	{
		char[] ch = s.toCharArray();
		String ss = "";
		for(int i=ch.length-1;i>=0;i--)
			ss += String.valueOf(ch[i]);
		return ss;
	}
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			while(sc.hasNext())
			{
				int n = sc.nextInt();
				fun(n);
			}
	}
}
