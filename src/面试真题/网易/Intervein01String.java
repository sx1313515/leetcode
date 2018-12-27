package 面试真题.网易;

import java.util.Arrays;
import java.util.Scanner;

/*
  如果一个01串任意两个相邻位置的字符都是不一样的,
 我们就叫这个01串为交错01串。例如: "1","10101","0101010"都是交错01串。
小易现在有一个01串s,小易想找出一个最长的连续子串,
并且这个子串是一个交错01串。小易需要你帮帮忙求出最长的这样的子串的长度是多少。
 */
public class Intervein01String {
	public static int fun(String s)
	{
		char[] ch = s.toCharArray();
		int size = ch.length;
		int[] memo = new int[size];
		Arrays.fill(memo, 1);
		for(int i = 1;i<size;i++)
			if(ch[i]!=ch[i-1])
				memo[i] = memo[i-1]+1;
		int max = -1;
		for(int i=0;i<size;i++)
			max = Math.max(max, memo[i]);
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			String s = sc.next();
			System.out.println(fun(s));
		}
	}

}
