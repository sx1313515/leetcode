package realinterviewquestions.jinritoutiao;

import java.util.Arrays;
import java.util.Scanner;

public class RoomDivide {
	public static void fun(int[] a,int n)
	{
		int size = a.length;
		int index=0;
		int min=a[0];
		for(int i=1;i<size;i++)
		{
			if(a[i]<min)
			{
				min = a[i];
				index = i;
			}
		}
		int distance = (n+size-1-index)%size;
		int[] memo = new int[size];
		Arrays.fill(memo, min);
		for(int j=1;j<=distance;j++)
		{
			memo[(index+j-1)%(size-1)]= memo[(index+j-1)%(size-1)]+1;
		}
		for(int k=0;k<size;k++)
		{
			a[k] = a[k]-memo[k];
		}
		a[index] = min*size+distance;
		for(int i=0;i<size;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
		while(sc.hasNext())
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] a = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			fun(a,m);
		}
	}

}
