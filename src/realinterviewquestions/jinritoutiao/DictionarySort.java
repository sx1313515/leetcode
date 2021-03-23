package realinterviewquestions.jinritoutiao;

import java.util.Scanner;

public class DictionarySort {
	static long sum=0;
	static long m;
	static long n;
	public static void fun(long nn,long mm)
	{
		n = nn;
		m = mm;
		for(int i=1;i<10;i++)
		{
			if(i>n)
				return;
			m--;
			if(m==0)
			{
				System.out.println(i);
				return;
			}
			fun1(i);
		}
	}
	public static void fun1(long s2) {
		// TODO Auto-generated method stub
		for(int j=0;j<10;j++)
		{
			if((s2*10+j)>n)
				return;
			m--;
			if(m==0)
			{
				System.out.println((s2*10+j));
				return;
			}
			fun1(s2*10+j);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
		while(sc.hasNext())
		{
			long n = sc.nextLong();
			long m = sc.nextLong();
			fun(n,m);
		}
	}

}
