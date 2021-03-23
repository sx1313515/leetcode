package realinterviewquestions.jinritoutiao;

import java.util.Scanner;

public class Yihuo {

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
			int sum = 0;
			for(int i=0;i<n-1;i++)
				for(int j=i+1;j<n;j++)
				{
					if((a[i]^a[j])>m)
						sum++;
				}
			System.out.println(sum);
		}
	}

}
