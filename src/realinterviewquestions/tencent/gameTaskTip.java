package realinterviewquestions.tencent;

import java.util.Scanner;

public class gameTaskTip {
	public static int fun(int n,int m)
	{
		if(n<1||n>1024||m<1||m>1024)
			return -1;
		if(n==m)
			return 1;
		else
			return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
				int n = sc.nextInt();
				int m = sc.nextInt();
				System.out.println(fun(n, m));
		}
	}

}
