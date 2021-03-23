package realinterviewquestions.meituan;
/*
 * 小萌非常喜欢能被 7 整除的数字，比如 7,21,121996，等等。有一天他得到了 n 个正整数，她想用这些数制造出更多的能够被 7 整除的数。于是她从这 n 个数中选出两个数，然后将一个数写在另一个数的前面，以此得到一个新的数。按这种方法她一共可以得到个数，她想知道在这些数中，有多少个是能被 7 整除的。
 */

import java.util.HashSet;
import java.util.Scanner;

public class Mod7Combine {
	public static long fun(int[] a)
	{
		HashSet<String> set = new HashSet<>();
		int size = a.length;
		for(int i=0;i<size-1;i++)
		{
			for(int j=i+1;j<size;j++)
			{
				String s1 = String.valueOf(a[i]);
				String s2 = String.valueOf(a[j]);
				String ss1 = s1+s2;
				if(Long.parseLong(ss1)%7==0)
					set.add(ss1);
				String ss2 = s2+s1;
				if(Long.parseLong(ss2)%7==0)
					set.add(ss2);
			}
		}
		return set.size();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
