package 面试真题.京东;

public class DivideApple {
/*
 * 果园里有一堆苹果，一共n头(n大于1小于9)熊来分，第一头为小东，
 * 它把苹果均分n份后，多出了一个，它扔掉了这一个，
 * 拿走了自己的一份苹果，接着第二头熊重复这一过程，
 * 即先均分n份，扔掉一个然后拿走一份，
 * 以此类推直到最后一头熊都是这样(最后一头熊扔掉后可以拿走0个，
 * 也算是n份均分)。问最初这堆苹果最少有多少个。
  给定一个整数n,表示熊的个数，返回最初的苹果数。保证有解。
 */
	public static int getInitial(int n) {
		for(int i=n+1;;i++)
		{
			int bear = n;
			int temp = i;
			while(bear>0)
			{
				if(temp%n==1)
				{
					temp = temp-1-temp/n;
					bear--;
				}
				else
				{
					break;
				}
			}
			if(bear==0)
				return i;
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		System.out.println(getInitial(n));
		System.out.println();
	}

}
