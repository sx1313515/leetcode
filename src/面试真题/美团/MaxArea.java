package 面试真题.美团;

import java.util.Scanner;

public class MaxArea {
	public static Long CountMaxArea(int[] a)
	{
		Long max=(long) 0;
		int length = a.length;
		for(int i=0;i<length;i++)
		{
			int minHeight=a[i];
			for(int j=i+1;j<length;j++)
			{
				minHeight = Math.min(minHeight,a[j]);
				max = Math.max(max,(j-i+1)*minHeight);
			}
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("输入数组大小");
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] a = new int[n];
		System.out.println("输入数组的元素：");
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println("最大面积为："+CountMaxArea(a));
	}

}
