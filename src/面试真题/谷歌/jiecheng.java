package 面试真题.谷歌;

/*
 * n!后面有多少个0，n很大
 */
public class jiecheng {
	public static int totalzero(int n)
	{
		int total = 0;
		for(int i=n;i>=5;i--)
			total += perzero(i);
		return total;
	}
	public static int perzero(int n)
	{
		int sum = 0;
		while(n>=5)
		{
			if(n%5==0)
			{
				sum+=1;
				n = n/5;
			}
			else
			  break;
		}
		return sum;
	}
	public static void main(String[] args) {
//		int n =1024;
//		System.out.println(totalzero(n));
	}
}
