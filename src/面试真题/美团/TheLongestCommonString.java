package 面试真题.美团;

import java.util.Scanner;

/*
 * 给出两个字符串（可能包含空格）,
 * 找出其中最长的公共连续子串,输出其长度。
 */
public class TheLongestCommonString {
	public static int Find(char[] a,char[] b)
	{
		int lengtha = a.length;
		int lengthb = b.length;
		int i=0,j=0;
		int Amax = 0;
		int max=0;
		int num=0;
		int p=0,q=0;
		int index=0;
		while(i<lengtha)
		{
			i = q;
			while(j<lengthb)
			{
				j = p;
				while(a[i]==b[j])
				{
					i++;j++;
					num++;
					if(i>=lengtha||j>=lengthb)
						break;
				}
				max = Math.max(num,max);
				num = 0;
				++p;
				if(p>=lengthb)
					break;
			}
			if(max>Amax)
			{
				Amax = max;
				index = q;
			}
			max = 0;
			p=0;
			q++;
			if(q>=lengtha)
				break;
		}
		return Amax;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s1  = sc.nextLine();
		String s2 = sc.nextLine();
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int commonLength;
		if(c1.length>=c2.length)
		{
			commonLength = Find(c1, c2);
		}
		else
		{
			commonLength = Find(c2,c1);
		}
		System.out.println(commonLength);
		
	}

}
