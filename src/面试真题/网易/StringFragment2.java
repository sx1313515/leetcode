package 面试真题.网易;

import java.text.DecimalFormat;
import java.util.Scanner;

public class StringFragment2 {
	public static void fun(String s)
	{
		char[] ch = s.toCharArray();
		float size = ch.length;
		if(size==1)
			System.out.println("1.00");
		float sum = 1.0f;
		char c = ch[0];
		for(int i=1;i<size;i++)
		{
			if(ch[i] != c)
			{
				sum++;
				c = ch[i];
			}
		}
		float result = size/sum;
		DecimalFormat fnum = new DecimalFormat("##0.00");
		System.out.println(fnum.format(result));;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
				String s = sc.next();
				fun(s);
		}
	}

}
