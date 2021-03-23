package realinterviewquestions.xiechen;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteSameString {
	public static void fun(String s)
	{
		char[] ch = s.toCharArray();
		int leng = ch.length;
		char[] memo = new char[leng];
		Arrays.fill(memo, '#');
		memo[0] = ch[0];
		int index = 0;
		for(int i=1;i<leng;i++)
		{
			int j;
			for(j=0;j<=i-1;j++)
			{
				if(ch[j]==ch[i])
					break;
			}
			if(j==i)
			{
				memo[++index] = ch[i];
			}
		}
		System.out.println(String.valueOf(memo, 0, index+1));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			String s = sc.nextLine();
			fun(s);
		}
	}

}
