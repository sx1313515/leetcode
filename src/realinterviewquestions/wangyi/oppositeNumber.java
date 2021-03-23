package realinterviewquestions.wangyi;
/*
 * 为了得到一个数的"相反数",我们将这个数的数字顺序颠倒,
 * 然后再加上原先的数得到"相反数"。例如,为了得到1325的"相反数",
 * 首先我们将该数的数字顺序颠倒,我们得到5231,之后再加上原先的数,
 * 我们得到5231+1325=6556.如果颠倒之后的数字有前缀零,前缀零将会被忽略。
 * 例如n = 100, 颠倒之后是1.
 */
import java.util.Scanner;

public class oppositeNumber {
	public static int fun(int n)
	{
		int nn = n;
		if(n==0)
			return 0;
		while(nn%10==0)
		{
			nn = nn/10;
		}
		String s = String.valueOf(nn);
		char[] ch = s.toCharArray();
		for(int i=0;i<=(ch.length/2-1);i++)
		{
			char temp = ch[i];
			ch[i] = ch[ch.length-1-i];
			ch[ch.length-1-i] = temp;
		}
		String ss = String.valueOf(ch);
		int nnn = Integer.valueOf(ss);
		return n+nnn;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
				int n = sc.nextInt();
				System.out.println(fun(n));
		}
	}

}
